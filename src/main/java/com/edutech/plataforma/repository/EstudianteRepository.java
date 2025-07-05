package com.edutech.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.plataforma.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    Estudiante findByPersonaRut(String rut);
    boolean existsByPersonaRut(String rut);
    //Patricio
}
