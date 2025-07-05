package com.edutech.plataforma.DTO;

public class CursoEditDTO {

    private String siglas;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int valor;
    private String rutProfesor;

    public CursoEditDTO() {
        this.siglas = "";
        this.nombre = "";
        this.descripcion = "";
        this.tipo = "";
        this.valor = 0;
        this.rutProfesor = "";
    }
    
    public CursoEditDTO(String siglas, String nombre, String descripcion, String tipo, int valor, String rutProfesor) {
        this.siglas = siglas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.rutProfesor = rutProfesor;
    }
    
    public String getSiglas() {
        return siglas;
    }
    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getRutProfesor() {
        return rutProfesor;
    }
    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
}
