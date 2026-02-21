package com.ticketing.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter @Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="registration_id")
    private Long registrationId;

    private Double amount;
    private String method;
    private String status;

    @Column(name="transaction_id")
    private String transactionId;

    @Column(name="paid_at")
    private LocalDateTime paidAt;
}