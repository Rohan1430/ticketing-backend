package com.ticketing.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tickets")
@Getter @Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_id")
    private Long eventId;

    private String type;
    private Double price;

    @Column(name="quantity_available")
    private Integer quantityAvailable;
}