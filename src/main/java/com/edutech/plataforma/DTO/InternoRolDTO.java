package com.edutech.plataforma.DTO;

public class InternoRolDTO {
    private String rut;
    private int idRol;

    public InternoRolDTO(){
        this.rut = "";
        this.idRol = 0;
    }

    public InternoRolDTO(String rut, int idRol) {
        this.rut = rut;
        this.idRol = idRol;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    
}
