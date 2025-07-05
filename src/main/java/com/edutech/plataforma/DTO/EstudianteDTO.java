package com.edutech.plataforma.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EstudianteDTO {

    private String nombre;
    private String direccion;
    private String correo;
    private int idPago;
    private String contrasena;
    private LocalDate fecha;

    public EstudianteDTO(String nombre, String direccion, String correo, int idPago,
                            String contrasena, LocalDate fecha) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.idPago = idPago;
        this.contrasena = contrasena;
        this.fecha = fecha;
    }

    public EstudianteDTO() {
        this.nombre = "";
        this.direccion = "";
        this.correo = "";
        this.idPago = 0;
        this.fecha = LocalDate.now();
        this.contrasena = "";
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
}
