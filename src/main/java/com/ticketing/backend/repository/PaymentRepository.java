package com.ticketing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketing.backend.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}