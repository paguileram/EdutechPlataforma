package com.edutech.plataforma.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_rut", referencedColumnName = "rut")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "metodopago_id")
    private MetodoPago metodopago;

    @ManyToMany
    @JoinTable(
        name= "estudiante_curso",
        joinColumns= @JoinColumn(name= "estudiante_id"),
        inverseJoinColumns= @JoinColumn(name= "siglas")
    )
    private List<Curso> cursos;

    public Estudiante(){
        this.id = 0;
    }

    public Estudiante(int id, String motodoPago){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public MetodoPago getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(MetodoPago metodopago) {
        this.metodopago = metodopago;
    }

}
