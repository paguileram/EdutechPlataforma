package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.model.Proveedor;
import com.edutech.plataforma.service.ProveedorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/{rut}")
    public String registroProveedor(@PathVariable String rut, @RequestBody Proveedor proveedor) {
        return proveedorService.registroProveedor(rut, proveedor);
    }
    
    @GetMapping("/{rut}")
    public List<Proveedor> listar(@PathVariable String rut) {
        return proveedorService.listar(rut);
    }
    //Patricio
}
