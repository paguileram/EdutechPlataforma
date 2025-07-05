package com.edutech.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public String almacenar(Rol rol){
        rolRepository.save(rol);
        return "Ok";
    }

    public List<Rol> obtenerRoles(){
        return rolRepository.findAll();
    }

    public Rol encontrar(int id){
        return rolRepository.findById(id).get();
    }
    
    public boolean existe(int id){
        return rolRepository.findById(id).isPresent();
    }
    //Cristobal
}
