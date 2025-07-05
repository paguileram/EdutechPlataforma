package com.edutech.plataforma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reporte;

    @ManyToOne
    @JoinColumn(name = "interno_id")
    private Interno interno;

    public Reporte(){
        this.id = 0;
        this.reporte = "";
    }

    public Reporte(int id, String reporte) {
        this.id = id;
        this.reporte = reporte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Interno getInterno() {
        return interno;
    }

    public void setInterno(Interno interno) {
        this.interno = interno;
    }

    
}
