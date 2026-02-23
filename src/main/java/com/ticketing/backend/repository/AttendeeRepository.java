package com.ticketing.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ticketing.backend.entity.Attendee;

public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

    boolean existsByEmail(String email);   // ✅ required
}