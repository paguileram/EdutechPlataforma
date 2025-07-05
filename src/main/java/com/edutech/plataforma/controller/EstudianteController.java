package com.edutech.plataforma.controller;

import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.EstudianteDTO;
import com.edutech.plataforma.DTO.EstudianteRegisDTO;
import com.edutech.plataforma.DTO.LoginDTO;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.service.EstudianteService;
import com.edutech.plataforma.service.PersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/estudiante") // Define el prefijo de la URL para este controlador
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private PersonaService personaService;

    // 1. CREAR CUENTA (Registro de Estudiante)
    @PostMapping("/registrar")
    public String ingresarEstudiante(@RequestBody EstudianteRegisDTO estudianteRegisDTO) {
        return estudianteService.registrarEstudiante(estudianteRegisDTO);
    }

    // 2. LISTA ESTUDIANTES
    @GetMapping
    public List<Estudiante> listar(){
        return estudianteService.listar();
    }

    // 3. LOGIN
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return personaService.login(loginDTO);
    }

    // 4. MODIFICAR
    @PutMapping("/{rut}/modificar")
    public String modificarEstudiante(@PathVariable String rut, @RequestBody EstudianteDTO estudianteDTO) {
        return estudianteService.modificarEstudiante(rut, estudianteDTO);
    }
    //Cristobal
}
