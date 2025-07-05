package com.edutech.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.plataforma.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String>{

}
