package com.edutech.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Evaluacion;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.Nota;
import com.edutech.plataforma.model.Reporte;
import com.edutech.plataforma.repository.*;

@Service
public class ReporteService {

    // @Autowired
    // private PersonaRepository personaRepository;

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private EvaluacionRepository evaluacionRepository;


    public String generarReporte(String rut, String siglas){
        if(!internoRepository.existsByPersonaRut(rut)){
            return "Usuario no existe o no es interno";
        }
        if(!cursoRepository.existsById(siglas)){
            return "Curso no existe";
        }
        Curso curso = cursoRepository.findById(siglas).get();
        String reportar = curso.getSiglas()+" "+curso.getNombre()+"\n";
        reportar += "\tEstudiantes: "+curso.getEstudiantes().size()+"\n";
        List<Evaluacion> evaluaciones = evaluacionRepository.findAll();
        for (Evaluacion evaluacion : evaluaciones) {
            reportar += "\t\t"+evaluacion.getNombre()+"\n";
            List<Nota> notas = evaluacion.getNotas();
            for (Nota nota : notas) {
                reportar += "\t\t"+nota.getEstudiante().getPersona().getRut()+" "+
                    nota.getEstudiante().getPersona().getNombre()+"\n";
                reportar += "\t\tNota: "+nota.getNota()+"\n";
            }
        }

        Reporte reporte = new Reporte();
        Interno interno = internoRepository.findByPersonaRut(rut);
        reporte.setInterno(interno);
        reporte.setReporte(reportar);
        reporteRepository.save(reporte);
        return reportar;
        //Patricio
    }
}
