package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.MensajeDTO;
import com.edutech.plataforma.DTO.MensajeRespuestaDTO;
import com.edutech.plataforma.DTO.MensajeVerDTO;
import com.edutech.plataforma.service.MensajeRespuestaService;
import com.edutech.plataforma.service.MensajeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/mensajes")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;
    
    @Autowired
    private MensajeRespuestaService mensajeRespuestaService;

    @PostMapping("/enviar/{rut}")
    public String enviarMensaje(@PathVariable String rut, @RequestBody MensajeDTO mensajeDTO){
        return mensajeService.enviarMensaje(rut, mensajeDTO);
    }

    @GetMapping("/enviados/{rut}")
    public List<MensajeVerDTO> mensajesEnviados(@PathVariable String rut) {
        return mensajeService.obtenerMensajesRemi(rut);
    }

    @PostMapping("/enviados/{rut}/responder")
    public String responderRemi(@PathVariable String rut, @RequestBody MensajeRespuestaDTO mensajeRespuestaDTO){
        return mensajeRespuestaService.enviarRespuesta(rut, mensajeRespuestaDTO);
    }

    @GetMapping("/recibidos/{rut}")
    public List<MensajeVerDTO> mensajesRecibidos(@PathVariable String rut) {
        return mensajeService.obtenerMensajesDesti(rut);
    }

    @PostMapping("/recibidos/{rut}/responder")
    public String responderDesti(@PathVariable String rut, @RequestBody MensajeRespuestaDTO mensajeRespuestaDTO){
        return mensajeRespuestaService.enviarRespuesta(rut, mensajeRespuestaDTO);
    }

    @GetMapping("/ver/{rut}/{id}")
    public MensajeVerDTO verMensajeEnviado(@PathVariable String rut,@PathVariable int id) {
        return mensajeService.obtenerMensaje(rut,id);
    }
    //Patricio
}
