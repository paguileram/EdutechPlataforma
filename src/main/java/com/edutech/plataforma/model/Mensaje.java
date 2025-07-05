package com.edutech.plataforma.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime hora;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "remi_persona_rut")
    private Persona remitente;

    @ManyToOne
    @JoinColumn(name = "dest_persona_rut")
    private Persona destinatario;

    @OneToMany(mappedBy = "mensaje", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MensajeRespuesta> mensajeRespuestas;

    public Mensaje(){
        this.id = 0;
        this.hora = LocalDateTime.now();
        this.descripcion = "";
    }

    public Mensaje(int id, String descripcion) {
        this.id = id;
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

    public List<MensajeRespuesta> getMensajeRespuestas() {
        return mensajeRespuestas;
    }

    public void setMensajeRespuestas(List<MensajeRespuesta> mensajeRespuestas) {
        this.mensajeRespuestas = mensajeRespuestas;
    }
    
}
