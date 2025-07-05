package com.edutech.plataforma.DTO;

public class EstudianteRegisDTO {
    private String nombre;
    private String rut;
    private String contrasena;
    private String direccion;
    private String correo;
    private String fecha;

    private int idPago;

    public EstudianteRegisDTO(String nombre, String rut, String contrasena, String direccion, String correo,
            String fecha, int idPago) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
        this.idPago = idPago;
    }

    public EstudianteRegisDTO() {
        this.nombre = "";
        this.rut = "";
        this.contrasena = "";
        this.direccion = "";
        this.correo = "";  
        this.fecha = "";
        this.idPago = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
}
