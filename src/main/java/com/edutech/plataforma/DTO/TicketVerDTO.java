package com.edutech.plataforma.DTO;

import java.time.LocalDateTime;

public class TicketVerDTO {

    private int id;
    private String rut;
    private LocalDateTime hora;
    private String cuerpo;
    private boolean estado;

    public TicketVerDTO(int id, String rut, LocalDateTime hora, String cuerpo, boolean estado) {
        this.id = id;
        this.rut = rut;
        this.hora = hora;
        this.cuerpo = cuerpo;
        this.estado = estado;
    }

    public TicketVerDTO() {
        this.id = 0;
        this.rut = "";
        this.hora = LocalDateTime.now();
        this.cuerpo = "";
        this.estado = true;
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
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
