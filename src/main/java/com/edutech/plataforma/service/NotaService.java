package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.NotaDTO;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.model.Evaluacion;
import com.edutech.plataforma.model.Nota;
import com.edutech.plataforma.repository.*;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InternoRepository internoRepository;

    public String realizarEvaluacion(String rut, String sigla, int id){

        if(!estudianteRepository.existsByPersonaRut(rut)){
            return "Solo estudiantes pueden resolver la evaluacion";
        }
        if(!evaluacionRepository.findById(id).get().getCurso().getSiglas().equals(sigla)){
            return "Evaluacion no existe";
        }
        Estudiante est = estudianteRepository.findByPersonaRut(rut);
        Evaluacion eva = evaluacionRepository.findById(id).get();
        Nota nota = new Nota();
        nota.setEstudiante(est);
        nota.setEvaluacion(eva);
        notaRepository.save(nota);
        return "Evaluacion Realizada";
        //Patricio
    }

    public List<NotaDTO> verNotasAlumno(String rut, String sigla){
        List<NotaDTO> notasDTO = new ArrayList<>();
        if(!estudianteRepository.existsByPersonaRut(rut)){
            return notasDTO;
        }
        if(!cursoRepository.existsById(sigla)){
            return notasDTO;
        }
        List<Nota> notas = notaRepository.findAll();
        for (Nota nota : notas) {
            if(nota.getEstudiante().getPersona().getRut().equals(rut)
                && nota.getEvaluacion().getCurso().getSiglas().equals(sigla)){
                    NotaDTO notaDTO = new NotaDTO();
                    notaDTO.setNombre(nota.getEvaluacion().getNombre());
                    notaDTO.setNota(nota.getNota());
                    notasDTO.add(notaDTO);
            }
        }
        return notasDTO;
        //Patricio
    }

    public List<NotaDTO> verNotasProfesor(String rut, String sigla, String estudiante){
        List<NotaDTO> notasDTO = new ArrayList<>();
        if(!internoRepository.existsByPersonaRut(rut)){
            return notasDTO;
        }
        if(!cursoRepository.existsById(sigla)){
            return notasDTO;
        }
        if(!estudianteRepository.existsByPersonaRut(estudiante)){
            return notasDTO;
        }
        List<Nota> notas = notaRepository.findAll();
        System.out.println(notas);
        for (Nota nota : notas) {
            if(nota.getEstudiante().getPersona().getRut().equals(estudiante)
                && nota.getEvaluacion().getCurso().getSiglas().equals(sigla)){
                    NotaDTO notaDTO = new NotaDTO();
                    notaDTO.setNombre(nota.getEvaluacion().getNombre());
                    notaDTO.setNota(nota.getNota());
                    notasDTO.add(notaDTO);
            }
        }
        return notasDTO;
        //Patricio
    }

    public String evaluarNota(String profesorR, String sigla, int id, String estudianteR, double calificacion){
        if(!internoRepository.existsByPersonaRut(profesorR)){
            return "Profesor no existe";
        }
        if(!cursoRepository.existsById(sigla)){
            return "Curso no existe";
        }
        Curso curso = cursoRepository.findById(sigla).get();
        if(!curso.getInterno().getPersona().getRut().equals(profesorR)){
            return "Profesor no dicta esta clase";
        }
        if(!evaluacionRepository.existsById(id)){
            return "Evaluacion no existe";
        }
        Evaluacion eva = evaluacionRepository.findById(id).get();
        if(!eva.getCurso().getSiglas().equals(sigla)){
            return "Evaluacion no pertenece a curso";
        }
        if(!estudianteRepository.existsByPersonaRut(estudianteR)){
            return "Estudiante no existe";
        }
        List<Nota> notas = eva.getNotas();
        Nota notaTomar = new Nota();
        for (Nota nota : notas) {
            if(nota.getEstudiante().getPersona().getRut().equals(estudianteR)){
                notaTomar = nota;
            }
        }
        if(notaTomar.getEstudiante().equals("")){
            return "Evaluacion no realizada aun";
        }
        notaTomar.setNota(calificacion);
        notaRepository.save(notaTomar);
        return "Nota Revisada";
        //Patricio
    }
}
