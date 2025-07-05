package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    @PostMapping
    public String resgistrarPersona(@RequestBody Persona persona) {
        return "Persona registrada "+personaService.registrarPersona(persona);
    }

    @GetMapping
    public List<Persona> listarPersona() {
        return personaService.listar();
    }
    //Cristobal
}
