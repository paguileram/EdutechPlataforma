package com.edutech.plataforma.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double nota;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;


    public Nota() {
        this.id = 0;
        this.nota = 0;
    }

    public Nota(int id, double nota) {
        this.id = id;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

}
