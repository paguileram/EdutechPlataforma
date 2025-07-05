package com.edutech.plataforma.DTO;

public class TicketRespuestaDTO {

    private int id;
    private String contenido;

    public TicketRespuestaDTO(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public TicketRespuestaDTO(){
        this.id = 0;
        this.contenido = "";
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
