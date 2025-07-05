package com.edutech.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.plataforma.model.Mensaje;

public interface MensajeRepository extends JpaRepository<Mensaje, Integer>{
    List<Mensaje> findByRemitenteRut(String rut);
    List<Mensaje> findByDestinatarioRut(String rut);
    //Patricio
}
