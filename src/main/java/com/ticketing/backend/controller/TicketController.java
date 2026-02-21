package com.ticketing.backend.controller;

import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;

    @GetMapping("/event/{eventId}")
    public List<Ticket> getTicketsForEvent(@PathVariable Long eventId) {
        return ticketRepository.findByEventId(eventId);
    }
}