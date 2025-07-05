package com.edutech.plataforma.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Interno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String especialidad;
    private String descripcion;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_rut", referencedColumnName = "rut")
    private Persona persona;
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "interno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;

    public Interno(){
        this.id = 0;
        this.especialidad = "";
        this.descripcion = "";
    }

    public Interno(int id, String especialidad, String descripcion) {
        this.id = id;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
