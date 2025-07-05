package com.edutech.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.plataforma.DTO.TicketDTO;
import com.edutech.plataforma.DTO.TicketVerDTO;
import com.edutech.plataforma.model.Interno;
import com.edutech.plataforma.model.Persona;
import com.edutech.plataforma.model.Ticket;
import com.edutech.plataforma.repository.EstudianteRepository;
import com.edutech.plataforma.repository.InternoRepository;
import com.edutech.plataforma.repository.PersonaRepository;
import com.edutech.plataforma.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    private InternoRepository internoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    public String enviarTicket(String rut, TicketDTO ticketDTO){
        if(!personaRepository.findById(rut).isPresent()){
            return "Remitente no existe";
        }
        Persona remitente = personaRepository.findById(rut).get();
        Ticket ticket = new Ticket();
        ticket.setRemitente(remitente);
        ticket.setDescripcion(ticketDTO.getContenido());

        ticketRepository.save(ticket);

        return "Ticket Enviado";
        //Patricio
    }

    public List<TicketVerDTO> obtenerTickets(String rut){
        List<Ticket> tickets = ticketRepository.findByRemitenteRut(rut);
        List<TicketVerDTO> ticketsVerDTO = new ArrayList<>();
        for (Ticket ticket : tickets) {
            TicketVerDTO ticketVerDTO = new TicketVerDTO();
            ticketVerDTO.setId(ticket.getId());
            ticketVerDTO.setHora(ticket.getHora());
            ticketVerDTO.setCuerpo(ticket.getDescripcion());
            ticketsVerDTO.add(ticketVerDTO);
        }
        return ticketsVerDTO;
        //Patricio
    }

    public TicketVerDTO obtenerTicket(String rut, int id){
        TicketVerDTO ticketVerDTO = new TicketVerDTO();
        if(!personaRepository.findById(rut).isPresent()){
            ticketVerDTO.setCuerpo("Rut no encontrado");
            return ticketVerDTO;
        }
        if(!ticketRepository.findById(id).isPresent()){
            ticketVerDTO.setCuerpo("Mensaje no encontrado");
            return ticketVerDTO;
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticketVerDTO.setId(ticket.getId());
        ticketVerDTO.setHora(ticket.getHora());
        ticketVerDTO.setCuerpo(ticket.getDescripcion());

        return ticketVerDTO;
        //Patricio
    }

    public List<TicketVerDTO> obtenerTodosTickets(String rut){
        List<TicketVerDTO> ticketsVerDTO = new ArrayList<>();
        if(!personaRepository.findById(rut).isPresent()){
            TicketVerDTO ticketVerDTO = new TicketVerDTO();
            ticketVerDTO.setCuerpo("Rut no encontrado");
            ticketsVerDTO.add(ticketVerDTO);
            return ticketsVerDTO;
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            TicketVerDTO ticketVerDTO = new TicketVerDTO();
            ticketVerDTO.setCuerpo("No posee el rol necesario");
            ticketsVerDTO.add(ticketVerDTO);
            return ticketsVerDTO;
        }
        Interno interno = internoRepository.findByPersonaRut(rut);
        if(!(interno.getRol().getId()==1)){
            TicketVerDTO ticketVerDTO = new TicketVerDTO();
            ticketVerDTO.setCuerpo("No posee el rol necesario");
            ticketsVerDTO.add(ticketVerDTO);
            return ticketsVerDTO;
        }
        List<Ticket> tickets = ticketRepository.findAll();
        for (Ticket ticket : tickets) {
            TicketVerDTO ticketVerDTO = new TicketVerDTO();
            ticketVerDTO.setId(ticket.getId());
            ticketVerDTO.setHora(ticket.getHora());
            ticketVerDTO.setCuerpo(ticket.getDescripcion());
            ticketVerDTO.setRut(ticket.getRemitente().getRut());
            ticketsVerDTO.add(ticketVerDTO);
        }
        return ticketsVerDTO;
        //Patricio
    }

    public TicketVerDTO obtenerAdminTicket(String rut, int id){
        TicketVerDTO ticketVerDTO = new TicketVerDTO();
        if(!personaRepository.findById(rut).isPresent()){
            ticketVerDTO.setCuerpo("Rut no encontrado");
            return ticketVerDTO;
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            ticketVerDTO.setCuerpo("No posee el rol necesario");
            return ticketVerDTO;
        }
        Interno interno = internoRepository.findByPersonaRut(rut);
        if(!(interno.getRol().getId()==1)){
            ticketVerDTO.setCuerpo("No posee el rol necesario");
            return ticketVerDTO;
        }
        if(!ticketRepository.findById(id).isPresent()){
            ticketVerDTO.setCuerpo("Mensaje no encontrado");
            return ticketVerDTO;
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticketVerDTO.setId(ticket.getId());
        ticketVerDTO.setHora(ticket.getHora());
        ticketVerDTO.setCuerpo(ticket.getDescripcion());

        return ticketVerDTO;
        //Patricio
    }

    public String asignarTicketAdmin(String rut, int id){
        TicketVerDTO ticketVerDTO = new TicketVerDTO();
        if(!personaRepository.findById(rut).isPresent()){
            ticketVerDTO.setCuerpo("Rut no encontrado");
            return "Rut no encontrado";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno interno = internoRepository.findByPersonaRut(rut);
        if(!(interno.getRol().getId()==1)){
            return "No posee el rol necesario";
        }
        if(!ticketRepository.findById(id).isPresent()){
            ticketVerDTO.setCuerpo("Mensaje no encontrado");
            return "Mensaje no encontrado";
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setDestinatario(interno.getPersona());
        ticketRepository.save(ticket);
        return "Ticket "+id+" asignado a "+rut;
        //Patricio
    }

    public String completarTicket(String rut, int id){
        TicketVerDTO ticketVerDTO = new TicketVerDTO();
        if(!personaRepository.findById(rut).isPresent()){
            ticketVerDTO.setCuerpo("Rut no encontrado");
            return "Rut no encontrado";
        }
        if(estudianteRepository.existsByPersonaRut(rut)){
            return "No posee el rol necesario";
        }
        Interno interno = internoRepository.findByPersonaRut(rut);
        if(!(interno.getRol().getId()==1)){
            return "No posee el rol necesario";
        }
        if(!ticketRepository.findById(id).isPresent()){
            ticketVerDTO.setCuerpo("Mensaje no encontrado");
            return "Mensaje no encontrado";
        }
        Ticket ticket = ticketRepository.findById(id).get();
        ticket.setEstado(false);
        ticketRepository.save(ticket);
        return "Ticket "+id+" asignado resuelto";
        //Patricio
    }
}
