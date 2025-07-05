package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolservice;

    @PostMapping
    public String postMethodName(@RequestBody List<Rol> roles) {
        for (Rol rol : roles) {
            rolservice.almacenar(rol);
        }
        return "Lista Agregada";
    }

    @GetMapping
    public List<Rol> obtenerRoles() {
        return rolservice.obtenerRoles();
    }
    //Cristobal
}
