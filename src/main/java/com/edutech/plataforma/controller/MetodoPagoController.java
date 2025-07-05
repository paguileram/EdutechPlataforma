package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.service.MetodoPagoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/metodoPago")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoService metodoPagoService;

    @PostMapping
    public String postMethodName(@RequestBody List<MetodoPago> metodoPagos) {
        for (MetodoPago metodoPago : metodoPagos) {
            metodoPagoService.almacenar(metodoPago);
        }
        return "Lista Agregada";
    }

    @GetMapping
    public List<MetodoPago> obtenerMetodoPagos() {
        return metodoPagoService.obtenerMetodoPagos();
    }
    //Cristobal
}
