package com.ticketing.backend.controller;

import com.ticketing.backend.entity.Attendee;
import com.ticketing.backend.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendees")
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeRepository attendeeRepository;

    @PostMapping
    public Attendee create(@RequestBody Attendee attendee) {
        return attendeeRepository.save(attendee);
    }
}