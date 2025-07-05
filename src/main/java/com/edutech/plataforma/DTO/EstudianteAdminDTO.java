package com.edutech.plataforma.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstudianteAdminDTO {

        private String rut;
    private String nombre;
    private String direccion;
    private String contrasena;
    private String correo;
    private boolean activa;
    private LocalDate fecha;
    private int idPago;

    public EstudianteAdminDTO() {

        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.contrasena = "";
        this.correo = "";
        this.activa = true;
        this.fecha = LocalDate.now();
        this.idPago = 0;
    }
    
    public EstudianteAdminDTO(String nombre, String direccion, String contrasena, String correo, String especialidad,
            String descripcion, boolean activa, LocalDate fecha, String rut, int idPago) {
        
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.correo = correo;
        this.activa = activa;
        this.fecha = fecha;
        this.idPago = idPago;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public boolean isActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setFecha(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(fecha, formatter);
            this.fecha = date;
        } catch (Exception e) {
            this.fecha = LocalDate.now();
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

}
