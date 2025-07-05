package com.edutech.plataforma.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.EstudianteAdminDTO;
import com.edutech.plataforma.DTO.InternoAdminDTO;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.model.Rol;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.MetodoPagoRepository;
import com.edutech.plataforma.repository.PersonaRepository;
import com.edutech.plataforma.repository.RolRepository;

@Service
public class AdminService {
    
    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository ;
    
    public String modificarInterno(String rut, InternoAdminDTO dto){

        //ADMIN
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(!internoRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        if((internoRepository.findByPersonaRut(rut).getRol().getId()!=1)){
            return "No posee el rol necesario";
        }

        //PERSONA A EDITAR
        if(!personaRepository.findById(dto.getRut()).isPresent()){
            return "Usuario no existe";
        }
        if(!internoRepository.existsByPersonaRut(dto.getRut())){
            return "No es un empleado";
        }
        if(!rolRepository.existsById(dto.getRol())){
            return "Rol no existe";
        }
        Interno interno = internoRepository.findByPersonaRut(dto.getRut());
        Persona persona  = interno.getPersona();
        Rol rol = new Rol();

        //Comproba cambios en la Clase internos
        if(!dto.getDescripcion().isEmpty()){
            interno.setDescripcion(dto.getDescripcion());
        }
        if(!dto.getEspecialidad().isEmpty()){
            interno.setEspecialidad(dto.getEspecialidad());
        }
        if(interno.getRol().getId()!=dto.getRol()){
            rol = rolRepository.findById(dto.getRol()).get();
        }else{
            rol = interno.getRol();
        }
        //Revisa cambios en la Clase Persona
        if(!dto.getCorreo().isEmpty()){
            persona.setCorreo(dto.getCorreo());
        }
        if(!dto.getDireccion().isEmpty()){
            persona.setDireccion(dto.getDireccion());
        }
        if(!dto.getNombre().isEmpty()){
            persona.setNombre(dto.getNombre());
        }
        if(!dto.getContrasena().isEmpty()){
            persona.setContrasena(dto.getContrasena());
        }
        if(!dto.isActiva()==persona.isActiva()){
            persona.setActiva(dto.isActiva());
        }
        try {
            if(!dto.getFecha().equals(LocalDate.now())){
                persona.setFecha(dto.getFecha());
            }
        } catch (Exception e) {
            return "Formato de fecha invalido";
        }

        interno.setPersona(persona);
        interno.setRol(rol);
        internoRepository.save(interno);
        return "Interno modificado";
    }

    public String modificarEstudiante(String rut, EstudianteAdminDTO dto){

        //ADMIN
        if(!personaRepository.findById(rut).isPresent()){
            return "Usuario no existe";
        }
        if(!internoRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        if(!(internoRepository.findByPersonaRut(rut).getRol().getId()==1)){
            return "No posee el rol necesario";
        }

        //PERSONA A EDITAR
        if(!personaRepository.findById(dto.getRut()).isPresent()){
            return "Usuario no existe";
        }
        if(!estudianteRepository.existsByPersonaRut(dto.getRut())){
            return "No es un empleado";
        }
        if(!metodoPagoRepository.existsById(dto.getIdPago())){
            return "MrtodPago no existe";
        }
        Estudiante estudiante = estudianteRepository.findByPersonaRut(dto.getRut());
        Persona persona  = estudiante.getPersona();
        MetodoPago metodoPago = new MetodoPago();

        //Comproba cambios en la Clase internos
        if(estudiante.getMetodopago().getId()!=dto.getIdPago()){
           metodoPago = metodoPagoRepository.findById(dto.getIdPago()).get();
        }else{
            metodoPago = estudiante.getMetodopago();
        }
        //Revisa cambios en la Clase Persona
        if(!dto.getCorreo().isEmpty()){
            persona.setCorreo(dto.getCorreo());
        }
        if(!dto.getDireccion().isEmpty()){
            persona.setDireccion(dto.getDireccion());
        }
        if(!dto.getNombre().isEmpty()){
            persona.setNombre(dto.getNombre());
        }
        if(!dto.getContrasena().isEmpty()){
            persona.setContrasena(dto.getContrasena());
        }
        if(!dto.isActiva()==persona.isActiva()){
            persona.setActiva(dto.isActiva());
        }
        try {
            if(!dto.getFecha().equals(LocalDate.now())){
                persona.setFecha(dto.getFecha());
            }
        } catch (Exception e) {
            return "Formato de fecha invalido";
        }


        estudiante.setMetodopago(metodoPago);
        estudiante.setPersona(persona);
        estudianteRepository.save(estudiante);
        return "Interno modificado";
    }

}
