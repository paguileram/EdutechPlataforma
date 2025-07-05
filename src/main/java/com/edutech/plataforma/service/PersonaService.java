package com.edutech.plataforma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.LoginDTO;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.PersonaRepository;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository personaRepository;

    public String registrarPersona(Persona persona){

        if(personaRepository.findById(persona.getRut()).isPresent()){
            return "Persona ya inscrita";
        }

        personaRepository.save(persona);
        return persona.getRut();
        //Cristobal
    }

    public String login(LoginDTO loginDTO){
        if(!personaRepository.existsById(loginDTO.getRut())){
            return "Usuario o contraseña incorrectos";
        }else{
            Persona persona = personaRepository.findById(loginDTO.getRut()).get();
            if(!persona.getContrasena().equals(loginDTO.getContrasena())){
                return "Usuario o contraseña incorrectos";
            }else{
                if(!persona.isActiva()){
                    return "Usuario Bloquedo";
                }
            }
        }
        return "correcto";
        //Cristobal
    }

    public List<Persona> listar(){
        return personaRepository.findAll();
        //Cristobal
    };

    public Persona encontrar(String rut){
        return personaRepository.findById(rut).get();
        //Cristobal
    };

    public Boolean existe(String rut){
        return personaRepository.findById(rut).isPresent();
        //Cristobal
    };

}
