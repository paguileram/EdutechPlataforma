package com.edutech.plataforma.DTO;

public class CursoProfesorDTO {
    private int id;
    private String siglas;

    public CursoProfesorDTO(int id, String siglas) {
        this.id = id;
        this.siglas = siglas;
    }

    public CursoProfesorDTO() {
        this.id = 0;
        this.siglas = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    
}
