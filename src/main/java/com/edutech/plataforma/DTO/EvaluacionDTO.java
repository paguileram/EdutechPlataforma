package com.edutech.plataforma.DTO;

public class EvaluacionDTO {
    private String nombre;
    private int tipoevaluacion;
    private int porcentaje;

    public EvaluacionDTO(String nombre, int tipoevaluacion, int porcentaje) {
        this.nombre = nombre;
        this.tipoevaluacion = tipoevaluacion;
        this.porcentaje = porcentaje;
    }

    public EvaluacionDTO() {
        this.nombre = "";
        this.tipoevaluacion = 0;
        this.porcentaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoevaluacion() {
        return tipoevaluacion;
    }

    public void setTipoevaluacion(int tipoevaluacion) {
        this.tipoevaluacion = tipoevaluacion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
