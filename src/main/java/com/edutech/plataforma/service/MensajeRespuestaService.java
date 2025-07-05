package com.edutech.plataforma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.MensajeRespuestaDTO;
import com.edutech.plataforma.model.Mensaje;
import com.edutech.plataforma.model.MensajeRespuesta;
import com.edutech.plataforma.repository.MensajeRepository;
import com.edutech.plataforma.repository.MensajeRespuestaRepository;
import com.edutech.plataforma.repository.PersonaRepository;

@Service
public class MensajeRespuestaService {
    
    @Autowired
    private MensajeRespuestaRepository mensajeRespuestaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MensajeRepository mensajeRepository;

    public String enviarRespuesta(String rut, MensajeRespuestaDTO mensajeRespuestaDTO){
        if(!personaRepository.findById(rut).isPresent()){
            return "Remitente no existe";
        }
        int id = mensajeRespuestaDTO.getId();
        if(!mensajeRepository.findById(id).isPresent()){
            return "Mensaje padre no existe";
        }
        Mensaje mensaje = mensajeRepository.findById(id).get();

        MensajeRespuesta mensajeRespuesta = new MensajeRespuesta();
        mensajeRespuesta.setRutEnviado(rut);
        mensajeRespuesta.setDescripcion(mensajeRespuestaDTO.getContenido());
        mensajeRespuesta.setMensaje(mensaje);

        mensajeRespuestaRepository.save(mensajeRespuesta);

        return "Mensaje Enviado";
        //Patricio
    }

}
