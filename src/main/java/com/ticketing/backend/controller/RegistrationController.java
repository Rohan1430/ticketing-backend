package com.ticketing.backend.controller;

import com.ticketing.backend.entity.Registration;
import com.ticketing.backend.entity.Ticket;
import com.ticketing.backend.repository.RegistrationRepository;
import com.ticketing.backend.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationRepository registrationRepository;
    private final TicketRepository ticketRepository;

    @PostMapping("/book")
    public Registration bookTicket(@RequestParam Long attendeeId,
                                   @RequestParam Long ticketId,
                                   @RequestParam int quantity) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticket.getQuantityAvailable() < quantity) {
            throw new RuntimeException("Not enough tickets available");
        }

        ticket.setQuantityAvailable(ticket.getQuantityAvailable() - quantity);
        ticketRepository.save(ticket);

        Registration reg = new Registration();
        reg.setAttendeeId(attendeeId);
        reg.setTicketId(ticketId);
        reg.setQuantity(quantity);
        reg.setTotalAmount(ticket.getPrice() * quantity);
        reg.setStatus("PENDING");
        reg.setRegistrationNumber("REG-" + UUID.randomUUID());

        return registrationRepository.save(reg);
    }
}