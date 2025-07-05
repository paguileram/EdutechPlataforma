package com.edutech.plataforma.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.Codigo;
import com.edutech.plataforma.service.CodigoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/cupon")
public class CodigoController {

    @Autowired
    private CodigoService codigoService;

    @PostMapping("/gerente/{rut}/ingresar")
    public String ingresarCupon(@PathVariable String rut,@RequestBody Codigo codigo) {
        return codigoService.registrarCupon(rut,codigo);
    }

    @GetMapping("/gerente/{rut}/vincular/{sigla}/{id}")
    public String vincularCuponCurso(@PathVariable String rut,@PathVariable String sigla,@PathVariable int id) {
        return codigoService.vincularCupon(rut,sigla,id);
    }
    
    @GetMapping("/estudiante/{rut}/aplicar/{sigla}/{id}")
    public String aplicarCupon(@PathVariable String rut,@PathVariable String sigla,@PathVariable int id) {
        return codigoService.aplicarCupon(rut,sigla,id);
    }
    //Patricio
}
