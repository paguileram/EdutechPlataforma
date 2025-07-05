package com.edutech.plataforma.service;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.CursoDTO;
import com.edutech.plataforma.DTO.CursoEditDTO;
import com.edutech.plataforma.DTO.CursoEstudiantesDTO;
import com.edutech.plataforma.DTO.CursoProfesorDTO;
import com.edutech.plataforma.DTO.EstudianteCursoDTO;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.CursoRepository;
import com.edutech.plataforma.repository.EstudianteRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public String registroCurso(String rut, Curso curso){
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno interno = internoRepository.findByPersonaRut(rut);
        if(!(interno.getRol().getId()==2)){
            return "No posee el rol necesario";
        }
        if(cursoRepository.findById(curso.getSiglas()).isPresent()){
            return "Curso ya existe";
        }
        cursoRepository.save(curso);
        return "Curso Guardado";
        //Patricio

    }

    public String asignarProfesor(String rutGerente, CursoProfesorDTO cursoProfesorDTO){
        if(!personaRepository.findById(rutGerente).isPresent()){
            return "Usuario no existe";
        }
        if(estudianteRepository.existsByPersonaRut(rutGerente)){
            return "No posee el rol necesario";
        }
        Interno gerente = internoRepository.findByPersonaRut(rutGerente);
        if(!(gerente.getRol().getId()==2)){
            return "No posee el rol necesario";
        }
        if(!internoRepository.findById(cursoProfesorDTO.getId()).isPresent()){
            return "Profesor no encontrado";
        }
        if(!cursoRepository.findById(cursoProfesorDTO.getSiglas()).isPresent()){
            return "Curso no encontrado";
        }
        Curso curso = cursoRepository.findById(cursoProfesorDTO.getSiglas()).get();
        Interno profesor = internoRepository.findById(cursoProfesorDTO.getId()).get();
        curso.setInterno(profesor);
        cursoRepository.save(curso);
        return "Curso Guardado";
        //Patricio

    }

    public String inscribirseEstudiante(String rut, String sigla){
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(internoRepository.existsByPersonaRut(rut)){
            return "Usuario no es estudiante";
        }
        if(!estudianteRepository.existsByPersonaRut(rut)){
            return "No es estudiante";
        }
        if(!cursoRepository.existsById(sigla)){
            return "Curso no existe";
        }
        Curso curso = cursoRepository.findById(sigla).get();
        List<Estudiante> estudiantes = curso.getEstudiantes();
        Estudiante estudiante = estudianteRepository.findByPersonaRut(rut);
        if(estudiantes.contains(estudiante)){
            return "Estudiante ya inscrito en curso";
        }
        estudiante.getCursos().add(curso);
        estudianteRepository.save(estudiante);
        return "Estudiante "+rut+" inscrito a curso "+sigla;
        //Patricio

    }

    public List<CursoDTO> listarCursos(){
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoDTO> cursosMostrar = new ArrayList<>();
        if(cursos.isEmpty()){
            return cursosMostrar;
        }
        for (Curso curso : cursos) {
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setDescripcion(curso.getDescripcion());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setSiglas(curso.getSiglas());
            cursoDTO.setTipo(curso.getTipo());
            cursoDTO.setValor(curso.getValor());
            if(curso.getInterno() == null){
                cursoDTO.setRutProfesor("");
                cursoDTO.setNombreProfesor("");
            }else{
                cursoDTO.setRutProfesor(curso.getInterno().getPersona().getRut());
                cursoDTO.setNombreProfesor(curso.getInterno().getPersona().getNombre());
            }
            cursosMostrar.add(cursoDTO);
        }
        return cursosMostrar;
        //Patricio

    }

    public List<CursoEstudiantesDTO> listarCursosEstudiantes(){
        List<Curso> cursos = cursoRepository.findAll();
        List<CursoEstudiantesDTO> cursosMostrar = new ArrayList<>();
        if(cursos.isEmpty()){
            return cursosMostrar;
        }
        for (Curso curso : cursos) {
            CursoEstudiantesDTO cursoDTO = new CursoEstudiantesDTO();
            cursoDTO.setDescripcion(curso.getDescripcion());
            cursoDTO.setNombre(curso.getNombre());
            cursoDTO.setSiglas(curso.getSiglas());
            cursoDTO.setTipo(curso.getTipo());
            cursoDTO.setValor(curso.getValor());
            if(curso.getInterno() == null){
                cursoDTO.setRutProfesor("");
                cursoDTO.setNombreProfesor("");
            }else{
                cursoDTO.setRutProfesor(curso.getInterno().getPersona().getRut());
                cursoDTO.setNombreProfesor(curso.getInterno().getPersona().getNombre());
            }
            List<Estudiante> estudiantes = curso.getEstudiantes();
            List<EstudianteCursoDTO> estudiantesDTO = new ArrayList<>();
            if(!estudiantes.isEmpty()){
                for (Estudiante estudiante : estudiantes) {
                    EstudianteCursoDTO estudianteDTO = new EstudianteCursoDTO();
                    estudianteDTO.setNombre(estudiante.getPersona().getNombre());
                    estudianteDTO.setRut(estudiante.getPersona().getRut());
                    estudiantesDTO.add(estudianteDTO);
                }
            }
            cursoDTO.setEstudiantes(estudiantesDTO);
            cursosMostrar.add(cursoDTO);
        }
        return cursosMostrar;
        //Patricio

    }

    public String modificarCurso(String rut, CursoEditDTO cursoDTO){

        //Gerente
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(!internoRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        if(!(internoRepository.findByPersonaRut(rut).getRol().getId()==2)){
            return "No posee el rol necesario";
        }

        //CURSO A EDITAR
        if(!cursoRepository.findById(cursoDTO.getSiglas()).isPresent()){
            return "Curso no existe";
        }

        Curso curso = cursoRepository.findById(cursoDTO.getSiglas()).get();
        Interno profesor = curso.getInterno();
        Interno profesorCamb = new Interno();
        Persona persona = new Persona();
        profesorCamb.setPersona(persona);

        if(internoRepository.existsByPersonaRut(cursoDTO.getRutProfesor())){
            profesorCamb = internoRepository.findByPersonaRut(cursoDTO.getRutProfesor());
        }

        //Comproba cambios en la Clase internos
        if(!cursoDTO.getTipo().isEmpty()){
            curso.setTipo(cursoDTO.getTipo());
        }
        if(!cursoDTO.getDescripcion().isEmpty()){
            curso.setDescripcion(cursoDTO.getDescripcion());
        }
        if(cursoDTO.getValor()>0){
            curso.setValor(cursoDTO.getValor());
        }
        if(!cursoDTO.getNombre().isEmpty()){
            curso.setNombre(cursoDTO.getNombre());
        }
        if(profesorCamb.getPersona().getNombre().isEmpty()){
            curso.setInterno(profesor);
        }else{
            curso.setInterno(profesorCamb);
        }
        
        cursoRepository.save(curso);
        return "Curso modificado";
    }
}
