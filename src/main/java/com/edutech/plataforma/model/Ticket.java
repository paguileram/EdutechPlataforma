package com.edutech.plataforma.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime hora;
    private String descripcion;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "remi_persona_rut")
    private Persona remitente;

    @ManyToOne
    @JoinColumn(name = "dest_persona_rut")
    private Persona destinatario;

    public Ticket(){
        this.id = 0;
        this.hora = LocalDateTime.now();
        this.descripcion = "";
        this.estado = true;
    }

    public Ticket(int id, String descripcion) {
        this.id = id;
        this.hora = LocalDateTime.now();
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getRemitente() {
        return remitente;
    }

    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

}
