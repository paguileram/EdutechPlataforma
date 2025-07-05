package com.edutech.plataforma.service;
import com.edutech.plataforma.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.MensajeDTO;
import com.edutech.plataforma.DTO.MensajeVerDTO;
import com.edutech.plataforma.model.Mensaje;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.repository.MensajeRepository;

@Service
public class MensajeService {

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private MensajeRepository mensajeRepository;

    public String enviarMensaje(String rut, MensajeDTO mensajeDTO){

        if(!personaRepository.findById(mensajeDTO.getRutDestinatario()).isPresent()){
            return "Destinatario no existe";
        }
        if(!personaRepository.findById(rut).isPresent()){
            return "Remitente no existe";
        }
        Persona remitente = personaRepository.findById(rut).get();
        Persona destinatario = personaRepository.findById(mensajeDTO.getRutDestinatario()).get();

        Mensaje mensaje = new Mensaje();
        mensaje.setRemitente(remitente);
        mensaje.setDestinatario(destinatario);
        mensaje.setDescripcion(mensajeDTO.getContenido());

        mensajeRepository.save(mensaje);

        return "Mensaje Enviado";
        //Patricio

    }

    public List<MensajeVerDTO> obtenerMensajesRemi(String rut){
        List<Mensaje> mensajes = mensajeRepository.findByRemitenteRut(rut);
        List<MensajeVerDTO> mensajesDTO = new ArrayList<>();
        for (Mensaje mensaje : mensajes) {
            MensajeVerDTO mensajeVerDTO = new MensajeVerDTO();
            mensajeVerDTO.setRut(mensaje.getDestinatario().getRut());
            mensajeVerDTO.setId(mensaje.getId());
            mensajeVerDTO.setHora(mensaje.getHora());
            mensajeVerDTO.setCuerpo(mensaje.getDescripcion());
            mensajeVerDTO.setRespuestas(mensaje.getMensajeRespuestas());
            mensajesDTO.add(mensajeVerDTO);
        }
        return mensajesDTO;
        //Patricio
    }

    public List<MensajeVerDTO> obtenerMensajesDesti(String rut){
        List<Mensaje> mensajes = mensajeRepository.findByDestinatarioRut(rut);
        List<MensajeVerDTO> mensajesDTO = new ArrayList<>();
        for (Mensaje mensaje : mensajes) {
            MensajeVerDTO mensajeVerDTO = new MensajeVerDTO();
            mensajeVerDTO.setRut(mensaje.getRemitente().getRut());
            mensajeVerDTO.setId(mensaje.getId());
            mensajeVerDTO.setHora(mensaje.getHora());
            mensajeVerDTO.setCuerpo(mensaje.getDescripcion());
            mensajeVerDTO.setRespuestas(mensaje.getMensajeRespuestas());
            mensajesDTO.add(mensajeVerDTO);
        }
        return mensajesDTO;
        //Patricio
    }

    public MensajeVerDTO obtenerMensaje(String rut, int id){
        MensajeVerDTO mensajeVerDTO = new MensajeVerDTO();
        if(!personaRepository.findById(rut).isPresent()){
            mensajeVerDTO.setCuerpo("Rut no encontrado");
            return mensajeVerDTO;
        }
        if(!mensajeRepository.findById(id).isPresent()){
            mensajeVerDTO.setCuerpo("Mensaje no encontrado");
            return mensajeVerDTO;
        }
        Mensaje mensaje = mensajeRepository.findById(id).get();

        if(mensaje.getRemitente().getRut().equals(rut)){
            mensajeVerDTO.setRut(mensaje.getDestinatario().getRut());
        }else{
            mensajeVerDTO.setRut(mensaje.getRemitente().getRut());
        }
        mensajeVerDTO.setId(mensaje.getId());
        mensajeVerDTO.setHora(mensaje.getHora());
        mensajeVerDTO.setCuerpo(mensaje.getDescripcion());
        mensajeVerDTO.setRespuestas(mensaje.getMensajeRespuestas());

        return mensajeVerDTO;
        //Patricio
    }

}
