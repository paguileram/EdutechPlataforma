package com.edutech.plataforma.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.edutech.plataforma.model.MensajeRespuesta;

public class MensajeVerDTO {

    private int id;
    private String rut;
    private LocalDateTime hora;
    private String cuerpo;
    private List<MensajeRespuesta> respuestas;

    public MensajeVerDTO(int id, String rut, LocalDateTime hora, String cuerpo, List<MensajeRespuesta> respuestas) {
        this.id = id;
        this.rut = rut;
        this.hora = hora;
        this.cuerpo = cuerpo;
        this.respuestas = respuestas;
    }
    public MensajeVerDTO() {
        this.id = 0;
        this.rut = "";
        this.hora = LocalDateTime.now();
        this.cuerpo = "";
        this.respuestas = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getHora() {
        return hora;
    }
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public List<MensajeRespuesta> getRespuestas() {
        return respuestas;
    }
    public void setRespuestas(List<MensajeRespuesta> respuestas) {
        this.respuestas = respuestas;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    
}
