package com.edutech.plataforma.DTO;

public class PersonaDTO {
    private String nombre;
    private String rut;
    private String direccion;
    private String correo;
    private String fecha;
    
    public PersonaDTO(String nombre, String rut, String direccion, String correo, String fecha) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
    }

    public PersonaDTO() {
        this.nombre = "";
        this.rut = "";
        this.direccion = "";
        this.correo = "";
        this.fecha = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
