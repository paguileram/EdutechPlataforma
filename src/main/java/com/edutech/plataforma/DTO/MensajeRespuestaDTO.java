package com.edutech.plataforma.DTO;

public class MensajeRespuestaDTO {

    private int id;
    private String contenido;

    public MensajeRespuestaDTO(int id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public MensajeRespuestaDTO(){
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
