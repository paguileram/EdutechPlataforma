package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.EvaMostrarDTO;
import com.edutech.plataforma.DTO.EvaluacionDTO;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Evaluacion;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.TipoEvaluacion;
import com.edutech.plataforma.repository.CursoRepository;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.EvaluacionRepository;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.PersonaRepository;

@Service
public class EvaluacionService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TipoEvaluacionService tipoEvaluacionService;

    public String crearEvaluacion(String rut, String siglas, EvaluacionDTO evaluacionDTO){
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno profesor = internoRepository.findByPersonaRut(rut);
        if(!(profesor.getRol().getId()==3)){
            return "No posee el rol necesario";
        }
        if(!cursoRepository.existsById(siglas)){
            return "Curso no existe";
        }
        List<Evaluacion> lista = evaluacionRepository.findAll();
        for (Evaluacion eva : lista) {
            if(eva.getNombre().equals(evaluacionDTO.getNombre())
                && eva.getCurso().getSiglas().equals(siglas)){
                    return "Evaluacion ya existe";
            }
        }
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombre(evaluacionDTO.getNombre());
        evaluacion.setPorcentaje(evaluacionDTO.getPorcentaje());
        TipoEvaluacion tipo = tipoEvaluacionService.encontrar(evaluacionDTO.getTipoevaluacion());
        Curso curso = cursoRepository.findById(siglas).get();
        evaluacion.setTipoEvaluacion(tipo);
        evaluacion.setCurso(curso);
        evaluacionRepository.save(evaluacion);
        return "Evaluacion creada";
        //Patricio

    }

    public List<EvaMostrarDTO> verEvaluacionesPorCurso(String rut, String siglas){
        List<Evaluacion> evaluaciones = new ArrayList<>();
        List<EvaMostrarDTO> evaluacMostrar = new ArrayList<>();
        if(!personaRepository.findById(rut).isPresent()){
            return evaluacMostrar;
        }
        if(!cursoRepository.existsById(siglas)){
            return evaluacMostrar;
        }
        evaluaciones = evaluacionRepository.findAll();
        for (Evaluacion evaluacion : evaluaciones) {
            if(evaluacion.getCurso().getSiglas().equals(siglas)){
                EvaMostrarDTO evaMostrarDTO = new EvaMostrarDTO();
                evaMostrarDTO.setId(evaluacion.getId());
                evaMostrarDTO.setNombre(evaluacion.getNombre());
                evaMostrarDTO.setPorcentaje(evaluacion.getPorcentaje());
                evaluacMostrar.add(evaMostrarDTO);
            }
        }
        return evaluacMostrar;
        //Patricio
    }

}
