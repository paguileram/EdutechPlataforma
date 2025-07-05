package com.edutech.plataforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.EstudianteAdminDTO;
import com.edutech.plataforma.DTO.InternoAdminDTO;
import com.edutech.plataforma.service.AdminService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PutMapping("/{rut}/modificar/interno")
    public String modificarInterno(@PathVariable String rut, @RequestBody InternoAdminDTO interno) {
        return adminService.modificarInterno(rut, interno);
    }

    @PutMapping("/{rut}/modificar/estudiante")
    public String modificarEstudiante(@PathVariable String rut, @RequestBody EstudianteAdminDTO estudiante) {
        return adminService.modificarEstudiante(rut, estudiante);
    }
}
