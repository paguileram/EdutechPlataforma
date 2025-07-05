package com.edutech.plataforma.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MensajeRespuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rutEnviado;
    private LocalDateTime hora;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "mensaje_id")
    @JsonBackReference
    private Mensaje mensaje;

    public MensajeRespuesta() {
        this.id = 0;
        this.rutEnviado = "";
        this.hora = LocalDateTime.now();
        this.descripcion = "";
    }

    public MensajeRespuesta(int id, String rutEnviado, String descripcion) {
        this.id = id;
        this.rutEnviado = rutEnviado;
        this.hora = LocalDateTime.now();
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public String getRutEnviado() {
        return rutEnviado;
    }

    public void setRutEnviado(String rutEnviado) {
        this.rutEnviado = rutEnviado;
    }
    
}
