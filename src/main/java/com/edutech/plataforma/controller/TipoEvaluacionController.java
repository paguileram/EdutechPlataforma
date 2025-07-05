package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.TipoEvaluacion;
import com.edutech.plataforma.service.TipoEvaluacionService;

@RestController
@RequestMapping("/tipoEvaluacion")
public class TipoEvaluacionController {

    
    @Autowired
    private TipoEvaluacionService tipoEvaluacionService;

    @PostMapping
    public String postMethodName(@RequestBody List<TipoEvaluacion> tipoEvaluaciones) {
        for (TipoEvaluacion tipoEvaluacion : tipoEvaluaciones) {
            tipoEvaluacionService.almacenar(tipoEvaluacion);
        }
        return "Lista Agregada";
    }

    @GetMapping
    public List<TipoEvaluacion> obtenerTipoEvaluaciones() {
        return tipoEvaluacionService.obtenerTipoEvaluaciones();
    }
    //Patricio
}
