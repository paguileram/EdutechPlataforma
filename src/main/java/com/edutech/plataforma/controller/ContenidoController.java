package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.Contenido;
import com.edutech.plataforma.service.ContenidoService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @PostMapping("/profesor/{rut}/{siglas}")
    public String subirContenido(@PathVariable String rut, @RequestBody Contenido contenido, @PathVariable String siglas) {
        return contenidoService.subirContenido(rut, contenido, siglas);
    }

    @GetMapping("/gerente/{rut}/{id}")
    public String aprovarContenido(@PathVariable String rut, @PathVariable int id) {
        return contenidoService.aprovarContenido(rut, id);
    }
    
    @GetMapping("/gerente/{rut}")
    public List<Contenido> mostrarContenido(@PathVariable String rut) {
        return contenidoService.mostrarContenido(rut);
    }

    @GetMapping("/{rut}/{sigla}")
    public List<Contenido> mostrarContenidoPorCurso(@PathVariable String rut, @PathVariable String sigla) {
        return contenidoService.mostrarContenidoPorCurso(rut,sigla);
    }
    //Patricio
}
