package com.edutech.plataforma.DTO;

public class EstudianteCursoDTO {
    private String rut;
    private String nombre;

    public EstudianteCursoDTO(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }
    public EstudianteCursoDTO() {
        this.rut = "";
        this.nombre = "";
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
    
    
}
