package com.edutech.plataforma.DTO;

public class NotaDTO {

    private String nombre;
    private double nota;

    public NotaDTO(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public NotaDTO() {
        this.nombre = "";
        this.nota = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
