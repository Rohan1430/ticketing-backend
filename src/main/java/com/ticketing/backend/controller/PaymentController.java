package com.ticketing.backend.controller;

import com.ticketing.backend.entity.Payment;
import com.ticketing.backend.entity.Registration;
import com.ticketing.backend.repository.PaymentRepository;
import com.ticketing.backend.repository.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository paymentRepository;
    private final RegistrationRepository registrationRepository;

    @PostMapping("/pay")
    public Payment pay(@RequestParam Long registrationId,
                       @RequestParam String method,
                       @RequestParam Double amount) {

        Registration reg = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new RuntimeException("Registration not found"));

        reg.setStatus("CONFIRMED");
        registrationRepository.save(reg);

        Payment payment = new Payment();
        payment.setRegistrationId(registrationId);
        payment.setAmount(amount);
        payment.setMethod(method);
        payment.setStatus("SUCCESS");
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaidAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}