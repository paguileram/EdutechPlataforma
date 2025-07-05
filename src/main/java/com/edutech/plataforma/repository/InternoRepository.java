package com.edutech.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.plataforma.model.Interno;

public interface InternoRepository extends JpaRepository<Interno, Integer>{
    Interno findByPersonaRut(String rut);
    boolean existsByPersonaRut(String rut);
    //Patricio
}
