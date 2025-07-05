package com.edutech.plataforma.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String insumo;
    private String nombre;

    public Proveedor(){
        this.id = 0;
        this.insumo = "";
        this.nombre = "";
    }

    public Proveedor(int id, String insumo, String nombre) {
        this.id = id;
        this.insumo = insumo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getInsumo() {
        return insumo;
    }
    public void setInsumo(String insumo) {
        this.insumo = insumo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
