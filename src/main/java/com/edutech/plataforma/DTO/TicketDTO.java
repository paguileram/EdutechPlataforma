package com.edutech.plataforma.DTO;

public class TicketDTO {

    private String contenido;

    public TicketDTO() {
        this.contenido = "";
    }

    public TicketDTO(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}
