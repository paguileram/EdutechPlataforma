package com.edutech.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.TipoEvaluacion;
import com.edutech.plataforma.repository.TipoEvaluacionRepository;

@Service
public class TipoEvaluacionService {
    
    @Autowired
    private TipoEvaluacionRepository tipoEvaluacionRepository;

    public String almacenar(TipoEvaluacion tipoEvaluacion){
        tipoEvaluacionRepository.save(tipoEvaluacion);
        return "Ok";
    }

    public List<TipoEvaluacion> obtenerTipoEvaluaciones(){
        return tipoEvaluacionRepository.findAll();
    }

    public TipoEvaluacion encontrar(int id){
        return tipoEvaluacionRepository.findById(id).get();
    }
    
    public boolean existe(int id){
        return tipoEvaluacionRepository.findById(id).isPresent();
    }
    
    //Patricio
}
