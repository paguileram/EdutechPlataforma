package com.edutech.plataforma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.plataforma.DTO.TicketDTO;
import com.edutech.plataforma.DTO.TicketVerDTO;
import com.edutech.plataforma.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/enviar/{rut}")
    public String enviarMensaje(@PathVariable String rut, @RequestBody TicketDTO ticketDTO){
        return ticketService.enviarTicket(rut, ticketDTO);
    }

    @GetMapping("/enviados/{rut}")
    public List<TicketVerDTO> mensajesEnviados(@PathVariable String rut) {
        return ticketService.obtenerTickets(rut);
    }

    @GetMapping("/admin/{rut}")
    public List<TicketVerDTO> verTicketsRecibidos(@PathVariable String rut) {
        return ticketService.obtenerTodosTickets(rut);
    }


    @GetMapping("/admin/ver/{rut}/{id}")
    public TicketVerDTO verMensajeEnviado(@PathVariable String rut,@PathVariable int id) {
        return ticketService.obtenerAdminTicket(rut,id);
    }

    @GetMapping("/admin/ver/{rut}/{id}/asignar")
    public String asignarTicketAdmin(@PathVariable String rut,@PathVariable int id) {
        return ticketService.asignarTicketAdmin(rut,id);
    }

    @GetMapping("/admin/ver/{rut}/{id}/completar")
    public String completarTicketAdmin(@PathVariable String rut,@PathVariable int id) {
        return ticketService.completarTicket(rut,id);
    }
    //Patricio
}
