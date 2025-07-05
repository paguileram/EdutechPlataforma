package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.Proveedor;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private InternoRepository internoRepository;

    public String registroProveedor(String rut, Proveedor proveedor){
        if(!internoRepository.existsByPersonaRut(rut)){
            return "Usuario no existe o no es empleado";
        }
        if(internoRepository.findByPersonaRut(rut).getRol().getId()!=1){
            return "Solo admin pueden registrar proveedores";
        }
        List<Proveedor> lista = proveedorRepository.findAll();
        for (Proveedor prov : lista) {
            if(proveedor.getNombre().equals(prov.getNombre())){
                return "Proveedor ya registrado";
            }
        }
        proveedorRepository.save(proveedor);
        return "Proveedor registrado";
        //Patricio
    }

    public List<Proveedor> listar(String rut){
        List<Proveedor> lista = new ArrayList<>();
        if(!internoRepository.existsByPersonaRut(rut)){
            Proveedor prov = new Proveedor();
            prov.setNombre("Usuario no existe o no es empleado");
            lista.add(prov);
            return lista;
        }
        lista = proveedorRepository.findAll();
        return lista;
        //Patricio
    }
}
