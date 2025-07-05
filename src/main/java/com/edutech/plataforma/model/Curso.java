package com.edutech.plataforma.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

    @Id
    private String siglas;
    private String nombre;
    private String tipo;
    private String descripcion;
    private int valor;

    @ManyToMany(mappedBy="cursos")
    private List<Estudiante> estudiantes;

    @ManyToOne
    @JoinColumn(name = "interno_id")
    private Interno interno;

    public Curso() {
        this.siglas = "";
        this.nombre = "";
        this.tipo = "";
        this.descripcion = "";
        this.valor = 0;
    }

    public Curso(String siglas, String nombre, String tipo, String descripcion, int valor) {
        this.siglas = siglas;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.valor = valor;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Interno getInterno() {
        return interno;
    }

    public void setInterno(Interno interno) {
        this.interno = interno;
    }

    

}
