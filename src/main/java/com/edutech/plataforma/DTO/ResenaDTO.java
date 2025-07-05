package com.edutech.plataforma.DTO;

public class ResenaDTO {
    private String descripcion;
    private String nombre;

    public ResenaDTO(){
        this.descripcion = "";
        this.nombre = "";
    }

    public ResenaDTO(String descripcion, String nombre) {
        this.descripcion = descripcion;
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
