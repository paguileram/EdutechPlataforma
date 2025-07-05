package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.InternoDTO;
import com.edutech.plataforma.DTO.InternoRegisDTO;
import com.edutech.plataforma.DTO.LoginDTO;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.service.InternoService;
import com.edutech.plataforma.service.PersonaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/interno")
public class InternoController {
    
    @Autowired
    private InternoService internoService;

    @Autowired
    private PersonaService personaService;
    
    @PostMapping("/registrar")
    public String ingresarInterno(@RequestBody InternoRegisDTO internoRegisDTO){
        return internoService.registrarInterno(internoRegisDTO);
    }

    @GetMapping
    public List<Interno> listar() {
        return internoService.listar();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return personaService.login(loginDTO);
    }

    @PutMapping("/{rut}/modificar")
    public String modificarInterno(@PathVariable String rut, @RequestBody InternoDTO internoDTO) {
        return internoService.modificarInterno(rut, internoDTO);
    }
    //Cristobal
}
