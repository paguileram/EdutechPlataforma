package com.edutech.plataforma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutech.plataforma.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
    List<Ticket> findByRemitenteRut(String rut);
    List<Ticket> findByDestinatarioRut(String rut);
    //Patricio
}
