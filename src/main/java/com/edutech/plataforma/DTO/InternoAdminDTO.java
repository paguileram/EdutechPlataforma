package com.edutech.plataforma.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InternoAdminDTO {
    
    private String rut;
    private String nombre;
    private String direccion;
    private String contrasena;
    private String correo;
    private String especialidad;
    private String descripcion;
    private boolean activa;
    private LocalDate fecha;
    private int rol;

    public InternoAdminDTO() {

        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.contrasena = "";
        this.correo = "";
        this.especialidad = "";
        this.descripcion = "";
        this.activa = true;
        this.fecha = LocalDate.now();
        this.rol = 0;
    }
    
    public InternoAdminDTO(String nombre, String direccion, String contrasena, String correo, String especialidad,
            String descripcion, boolean activa, LocalDate fecha, String rut, int rol) {
        
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.correo = correo;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.activa = activa;
        this.fecha = fecha;
        this.rol = rol;
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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(fecha, formatter);
            this.fecha = date;
        } catch (Exception e) {
            this.fecha = LocalDate.now();
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    
}
