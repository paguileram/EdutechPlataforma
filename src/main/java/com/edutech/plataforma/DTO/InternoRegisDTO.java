package com.edutech.plataforma.DTO;

public class InternoRegisDTO {
    private String nombre;
    private String rut;
    private String contrasena;
    private String direccion;
    private String correo;
    private String fecha;
    private String especialidad;
    private String descripcion;

    private int rol;

    public InternoRegisDTO() {
        this.nombre         = "";
        this.rut            = "";
        this.contrasena     = "";
        this.direccion      = "";
        this.correo         = "";
        this.fecha          = "";
        this.especialidad   = "";
        this.descripcion    = "";
        this.rol            = 0;
    }

    public InternoRegisDTO(String nombre, String rut, String contrasena, String direccion, String correo, String fecha,
            String especialidad, String descripcion, int rol) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.rol = rol;
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
