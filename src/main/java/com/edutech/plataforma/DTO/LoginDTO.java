package com.edutech.plataforma.DTO;

public class LoginDTO {

    private String rut;
    private String contrasena;

    public LoginDTO(){
        this.rut = "";
        this.contrasena = "";
    }

    public LoginDTO(String rut, String contrasena) {
        this.rut = rut;
        this.contrasena = contrasena;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}
