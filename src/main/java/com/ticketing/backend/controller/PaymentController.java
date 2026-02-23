package com.ticketing.backend.controller;

import com.ticketing.backend.entity.Payment;
import com.ticketing.backend.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {

        payment.setPaidAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }
}