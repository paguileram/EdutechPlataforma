package com.edutech.plataforma.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.InternoDTO;
import com.edutech.plataforma.DTO.InternoRegisDTO;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.repository.InternoRepository;

@Service
public class InternoService {

    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private RolService rolService;

    public String registrarInterno(InternoRegisDTO internoRegisDTO){

        //Valida que no existe un interno registrado
        if(personaService.existe(internoRegisDTO.getRut())){
            return "Persona o Interno ya registrado en el sistema";
        }
        //Valida que el rol exista
        if(!rolService.existe(internoRegisDTO.getRol())){
            return "Rol no existente";
        }
        //Crea una nueva Persona para el Interno
        Persona persona = new Persona();
        persona.setNombre(internoRegisDTO.getNombre());
        persona.setRut(internoRegisDTO.getRut());
        persona.setContrasena(internoRegisDTO.getContrasena());
        persona.setDireccion(internoRegisDTO.getDireccion());
        persona.setCorreo(internoRegisDTO.getCorreo());
        try {
            persona.setFecha(internoRegisDTO.getFecha());
        } catch (Exception e) {
            System.out.println("Formato de fecha invalido"+e);
            return "Fecha mal ingresada";
        }
        //Crea un Rol para el Interno
        Rol rol = rolService.encontrar(internoRegisDTO.getRol());

        //Crea los campos propios de la Clase Interno
        Interno interno = new Interno();
        interno.setPersona(persona);
        interno.setRol(rol);
        interno.setEspecialidad(internoRegisDTO.getEspecialidad());
        interno.setDescripcion(internoRegisDTO.getDescripcion());

        //Guarda los cambios
        internoRepository.save(interno);

        return "Interno registrado "+internoRegisDTO.getRut()+" - "+rol.getRol();

        //Cristobal
    }

    public List<Interno> listar(){
        return internoRepository.findAll();
        //Cristobal
    }

    public String modificarInterno(String rut, InternoDTO internoDTO){
    
        //Comprueba que el rut Exista
        if(!internoRepository.existsByPersonaRut(rut)){
            return "Usuario no encontrado";
        }

        //Rescata a los campos originales
        Interno interno = internoRepository.findByPersonaRut(rut);
        Persona persona = interno.getPersona();

        //Comproba cambios en la Clase internos
        if(!internoDTO.getCorreo().isEmpty()){
            persona.setCorreo(internoDTO.getCorreo());
        }
        if(!internoDTO.getDescripcion().isEmpty()){
            interno.setDescripcion(internoDTO.getDescripcion());
        }
        if(!internoDTO.getEspecialidad().isEmpty()){
            interno.setEspecialidad(internoDTO.getEspecialidad());
        }
        //Revisa cambios en la Clase Persona
        if(!internoDTO.getDireccion().isEmpty()){
            persona.setDireccion(internoDTO.getDireccion());
        }
        if(!internoDTO.getNombre().isEmpty()){
            persona.setNombre(internoDTO.getNombre());
        }
        if(!internoDTO.getContrasena().isEmpty()){
            persona.setContrasena(internoDTO.getContrasena());
        }
        try {
            if(!internoDTO.getFecha().equals(LocalDate.now())){
                persona.setFecha(internoDTO.getFecha());
            }
        } catch (Exception e) {
            return "Formato de fecha invalido";
        }

        //Guarda los cambios
        interno.setPersona(persona);
        internoRepository.save(interno);
        return "Cambios realizados";
        //Cristobal
    }

}
