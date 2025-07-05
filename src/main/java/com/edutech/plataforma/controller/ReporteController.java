package com.edutech.plataforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.service.ReporteService;

@RestController
@RequestMapping("/reporte")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("{rut}/{siglas}")
    public String generarReporte(@PathVariable String rut, @PathVariable String siglas){
        return reporteService.generarReporte(rut,siglas);
    }
    //Patricio
}
