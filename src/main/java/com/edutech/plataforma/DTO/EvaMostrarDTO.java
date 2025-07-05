package com.edutech.plataforma.DTO;

public class EvaMostrarDTO {
    private int id;
    private String nombre;
    private int porcentaje;

    public EvaMostrarDTO(int id, String nombre, int porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public EvaMostrarDTO() {
        this.id = 0;
        this.nombre = "";
        this.porcentaje = 0;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    
}
