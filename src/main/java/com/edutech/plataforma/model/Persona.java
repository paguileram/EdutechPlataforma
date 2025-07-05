package com.edutech.plataforma.model;

import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Persona {

    @Id
    private String rut;
    private String nombre;
    private String contrasena;
    private String direccion;
    private String correo;
    private LocalDate fecha;
    private boolean activa;
    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets_recibido;
    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensaje> mensajes_recibido;
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets_enviado;
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mensaje> mensajes_enviado;
    
    public Persona(){
        this.rut = "";
        this.nombre = "";
        this.contrasena = "";
        this.direccion = "";
        this.correo = "";
        this.fecha = LocalDate.now();
        this.activa = true;
    }

    public Persona(String rut, String nombre, String direccion, String correo, LocalDate fecha) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
        this.activa = true;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(fecha, formatter);
        this.fecha = date;
    }
    
}
