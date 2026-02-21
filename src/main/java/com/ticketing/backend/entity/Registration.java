package com.ticketing.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registrations")
@Getter @Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="attendee_id")
    private Long attendeeId;

    @Column(name="ticket_id")
    private Long ticketId;

    private Integer quantity;

    @Column(name="total_amount")
    private Double totalAmount;

    @Column(name="registration_number")
    private String registrationNumber;

    private String status;
}