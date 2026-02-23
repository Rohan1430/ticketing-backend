package com.ticketing.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.repository.TicketRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private static final Logger log =
            LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketRepository ticketRepository;

    @Operation(summary = "Create ticket")
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {

        log.info("Creating ticket for event {}", ticket.getEventId());

        return ticketRepository.save(ticket);
    }

    @Operation(summary = "Get all tickets")
    @GetMapping
    public List<Ticket> getAllTickets() {

        log.info("Fetching tickets");

        return ticketRepository.findAll();
    }

}