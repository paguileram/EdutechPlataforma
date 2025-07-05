package com.edutech.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public String almacenar(MetodoPago metodoPago){
        metodoPagoRepository.save(metodoPago);
        return "Ok";
    }

    public List<MetodoPago> obtenerMetodoPagos(){
        return metodoPagoRepository.findAll();
    }

    public MetodoPago encontrar(int id){
        return metodoPagoRepository.findById(id).get();
    }
    
    public boolean existe(int id){
        return metodoPagoRepository.findById(id).isPresent();
    }
    //Cristobal
}
