package com.edutech.plataforma.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.edutech.plataforma.DTO.EstudianteDTO;
import com.edutech.plataforma.DTO.EstudianteRegisDTO;
import com.edutech.plataforma.model.Estudiante;
import com.edutech.plataforma.model.MetodoPago;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private MetodoPagoService metodoPagoService;

    // 1. CREAR CUENTA (Registro de Estudiante)
    public String registrarEstudiante(EstudianteRegisDTO estudianteRegisDTO){

        // Validar si el RUT ya existe
        if(personaService.existe(estudianteRegisDTO.getRut())){
            return "Persona o Estudiante ya registrado en el sistema";
        }
        // Validar y obtener Método de Pago
        if(!metodoPagoService.existe(estudianteRegisDTO.getIdPago())){
            return "Metodo de pago invalido";
        }
        MetodoPago pago = metodoPagoService.encontrar(estudianteRegisDTO.getIdPago());

        // Crear la Persona
        Persona persona = new Persona();
        persona.setNombre(estudianteRegisDTO.getNombre());
        persona.setRut(estudianteRegisDTO.getRut());
        persona.setContrasena(estudianteRegisDTO.getContrasena());
        persona.setDireccion(estudianteRegisDTO.getDireccion());
        persona.setCorreo(estudianteRegisDTO.getCorreo());
        try {
            persona.setFecha(estudianteRegisDTO.getFecha());
        } catch (Exception e) {
            System.out.println("Formato de fecha invalido"+e);
            return "Formato de fecha invalido";
        }
        // Asegúrate de que el formato de fecha que recibes en el DTO (ej. "dd-MM-yyyy")
        

        Estudiante estudiante = new Estudiante();

        //Asigna Persona y Pago
        estudiante.setPersona(persona);
        estudiante.setMetodopago(pago);

         // Guardar la Person
        estudianteRepository.save(estudiante);
        return "Estudiante Registrado "+estudiante.getId();
        //Cristobal
    }
    
    @GetMapping
    public List<Estudiante> listar() {
        //Obtiene Lista de estudiantes
        //Cristobal
        return estudianteRepository.findAll();
    }

    public String modificarEstudiante(String rut, EstudianteDTO estudianteDTO){

        //Valida si existe el usuario
        if(!estudianteRepository.existsByPersonaRut(rut)){
            return "Usuario no encontrado";
        }

        //Busca y Trae un Estudiante por su RUT
        Estudiante estudiante = estudianteRepository.findByPersonaRut(rut);
        //Trae a la Clase Persona del Estudiante
        Persona persona = estudiante.getPersona();
        //Valida si cambio el metodo de pago
        MetodoPago metodoPago;
        if(estudianteDTO.getIdPago()!=0){
            metodoPago = metodoPagoService.encontrar(estudianteDTO.getIdPago());
            estudiante.setMetodopago(metodoPago);
        }
        if(!estudianteDTO.getCorreo().isEmpty()){
            persona.setCorreo(estudianteDTO.getCorreo());
        }
        //Valida si se hico un cambio en los campos del DTO
        //Valida si el campo a cambia este vacio y si contiene texto
        //lo cambia
        if(!estudianteDTO.getDireccion().isEmpty()){
            persona.setDireccion(estudianteDTO.getDireccion());
        }
        if(!estudianteDTO.getNombre().isEmpty()){
            persona.setNombre(estudianteDTO.getNombre());
        }
        if(!estudianteDTO.getContrasena().isEmpty()){
            persona.setContrasena(estudianteDTO.getContrasena());
        }
        try {
            if(!estudianteDTO.getFecha().equals(LocalDate.now())){
                persona.setFecha(estudianteDTO.getFecha());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        //Agrega la Clase Persona al estudiantes con los
        //Cambios realizados y lo guarda
        estudiante.setPersona(persona);
        estudianteRepository.save(estudiante);
        return "Cambios realizados";

        //Cristobal
    }
}
