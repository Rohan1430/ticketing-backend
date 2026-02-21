package com.ticketing.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendees")
@Getter @Setter
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String email;
    private String mobile;
    private String city;
    private String country;
}