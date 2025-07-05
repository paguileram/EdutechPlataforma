package com.edutech.plataforma.DTO;

import java.util.ArrayList;
import java.util.List;

public class CursoEstudiantesDTO {
    private String siglas;
    private String nombre;
    private String descripcion;
    private String tipo;
    private int valor;
    private String rutProfesor;
    private String nombreProfesor;
    private List<EstudianteCursoDTO> estudiantes;

    public CursoEstudiantesDTO(String siglas, String nombre, String descripcion, String tipo, int valor, String rutProfesor,
            String nombreProfesor, List<EstudianteCursoDTO> estudiantes) {
        this.siglas = siglas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor = valor;
        this.rutProfesor = rutProfesor;
        this.nombreProfesor = nombreProfesor;
        this.estudiantes = estudiantes;
    }

    public CursoEstudiantesDTO() {
        this.siglas = "";
        this.nombre = "";
        this.descripcion = "";
        this.tipo = "";
        this.valor = 0;
        this.rutProfesor = "";
        this.nombreProfesor = "";
        this.estudiantes = new ArrayList<>();
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getRutProfesor() {
        return rutProfesor;
    }

    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public List<EstudianteCursoDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteCursoDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
