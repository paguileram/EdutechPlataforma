package com.edutech.plataforma.controller;

import java.util.List;
import com.edutech.plataforma.service.NotaService;
import com.edutech.plataforma.service.ResenaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.CursoDTO;
import com.edutech.plataforma.DTO.CursoEditDTO;
import com.edutech.plataforma.DTO.CursoEstudiantesDTO;
import com.edutech.plataforma.DTO.CursoProfesorDTO;
import com.edutech.plataforma.DTO.EvaMostrarDTO;
import com.edutech.plataforma.DTO.EvaluacionDTO;
import com.edutech.plataforma.DTO.NotaDTO;
import com.edutech.plataforma.DTO.ResenaDTO;
import com.edutech.plataforma.model.Curso;
import com.edutech.plataforma.model.Resena;
import com.edutech.plataforma.service.CursoService;
import com.edutech.plataforma.service.EvaluacionService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private NotaService notaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EvaluacionService evaluacionService;

    @Autowired
    private ResenaService resenaService;

    CursoController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping("/gerente/{rut}/registrar")
    public String registrarCurso(@PathVariable String rut, @RequestBody Curso Curso){
        return cursoService.registroCurso(rut, Curso);
    }

    @PostMapping("/gerente/{rut}/asignar")
    public String asignarProfesorCurso(@PathVariable String rut, @RequestBody CursoProfesorDTO Curso){
        return cursoService.asignarProfesor(rut, Curso);
    }

    @GetMapping
    public List<CursoDTO> listarCursos(){
        return cursoService.listarCursos();
    }
    
    @PutMapping("/gerente/{rut}/modificar")
    public String modificarCurso(@PathVariable String rut, @RequestBody CursoEditDTO curso) {
        return cursoService.modificarCurso(rut, curso);
    }

    @GetMapping("/cursosEstudiantes")
    public List<CursoEstudiantesDTO> listarCursosEstudiantes(){
        return cursoService.listarCursosEstudiantes();
    }

    @GetMapping("/{rut}/inscribir/{sigla}")
        public String inscribirseEstudiante(@PathVariable String rut, @PathVariable String sigla){
        return cursoService.inscribirseEstudiante(rut,sigla);
    }

    @PostMapping("/profesor/{rut}/{siglas}/evaluacion/crear")
    public String crearEvaluacion(@PathVariable String rut, @PathVariable String siglas, @RequestBody EvaluacionDTO evaluacion){
        return evaluacionService.crearEvaluacion(rut, siglas, evaluacion);
    }

    @GetMapping("/{rut}/{siglas}/evaluacion/")
    public List<EvaMostrarDTO> verEvaluacionesPorCurso(@PathVariable String rut, @PathVariable String siglas){
        return evaluacionService.verEvaluacionesPorCurso(rut,siglas);
    }

    @GetMapping("/{rut}/{siglas}/evaluacion/{id}")
    public String realizarEvaluacion(@PathVariable String rut, @PathVariable String siglas, @PathVariable int id){
        return notaService.realizarEvaluacion(rut,siglas,id);
    }

    @GetMapping("/{rut}/{siglas}/evaluacion/{id}/{estudiante}/{nota}")
    public String evaluarNota(@PathVariable String rut, @PathVariable String siglas, @PathVariable int id, @PathVariable String estudiante, @PathVariable double nota){
        return notaService.evaluarNota(rut,siglas,id,estudiante,nota);
    }

    @GetMapping("/{rut}/{siglas}/notas")
    public List<NotaDTO> verNotasAlumno(@PathVariable String rut, @PathVariable String siglas){
        return notaService.verNotasAlumno(rut,siglas);
    }
    @GetMapping("/{rut}/{siglas}/notas/{estudiante}")
    public List<NotaDTO> verNotasProfesor(@PathVariable String rut, @PathVariable String siglas,@PathVariable String estudiante){
        return notaService.verNotasProfesor(rut,siglas,estudiante);
    }

    @PostMapping("{rut}/{siglas}/resena")
    public String publicarReseña(@PathVariable String rut, @PathVariable String siglas, @RequestBody Resena resena){
        return resenaService.publicarReseña(rut, siglas, resena);
    }
    @GetMapping("{rut}/{siglas}/resena")
    public List<ResenaDTO> listarResenas(@PathVariable String rut, @PathVariable String siglas){
        return resenaService.listarResenas(rut, siglas);
    }
    //Patricio
}
