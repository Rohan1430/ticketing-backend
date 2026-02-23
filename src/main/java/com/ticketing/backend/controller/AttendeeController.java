package com.ticketing.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticketing.backend.entity.Attendee;
import com.ticketing.backend.repository.AttendeeRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    private static final Logger log =
            LoggerFactory.getLogger(AttendeeController.class);

    @Autowired
    private AttendeeRepository attendeeRepository;
    @PostMapping
    @Operation(summary = "Register attendee")
    public Object create(@RequestBody Attendee attendee) {

        if(attendeeRepository.existsByEmail(attendee.getEmail())) {
            return "Email already registered!";
        }

        return attendeeRepository.save(attendee);
    }

    @Operation(summary = "Get all attendees")
    @GetMapping
    public List<Attendee> getAll() {

        log.info("Fetching attendees");

        return attendeeRepository.findAll();
    }
}