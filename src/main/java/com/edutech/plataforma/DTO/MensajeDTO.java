package com.edutech.plataforma.DTO;

public class MensajeDTO {

    private String rutDestinatario;
    private String contenido;

    public MensajeDTO() {
        this.rutDestinatario = "";
        this.contenido = "";
    }

    public MensajeDTO(String rutDestinatario, String contenido) {
        this.rutDestinatario = rutDestinatario;
        this.contenido = contenido;
    }
    
    public String getRutDestinatario() {
        return rutDestinatario;
    }
    public void setRutDestinatario(String rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
}
