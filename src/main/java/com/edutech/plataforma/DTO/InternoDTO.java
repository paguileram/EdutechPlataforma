package com.edutech.plataforma.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InternoDTO {

    private String nombre;
    private String direccion;
    private String contrasena;
    private String correo;
    private String especialidad;
    private String descripcion;
    private LocalDate fecha;

    public InternoDTO() {
        this.nombre         = "";
        this.direccion      = "";
        this.correo         = "";
        this.especialidad   = "";
        this.descripcion    = "";
        this.contrasena     = "";
        this.fecha          = LocalDate.now();
    }

    public InternoDTO(String nombre, String direccion, String correo, String especialidad,
            String descripcion, String contrasena, LocalDate fecha) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.contrasena     = contrasena;
        this.fecha          = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
