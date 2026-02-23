package com.ticketing.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticketing.backend.entity.Event;
import com.ticketing.backend.repository.EventRepository;

import io.swagger.v3.oas.annotations.Operation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/events")
public class EventController {

    private static final Logger log =
            LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventRepository eventRepository;

    @Operation(summary = "Create a new event")
    @PostMapping
    public Event createEvent(@RequestBody Event event) {

        log.info("Creating event: {}", event.getName());

        return eventRepository.save(event);
    }

    @Operation(summary = "Get all events")
    @GetMapping
    public List<Event> getAllEvents() {

        log.info("Fetching all events");

        return eventRepository.findAll();
    }

    @Operation(summary = "Get event by ID")
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable("id") Long id) {

        log.info("Fetching event with id {}", id);

        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    @Operation(summary = "Delete event")
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable("id") Long id) {

        log.warn("Deleting event {}", id);

        eventRepository.deleteById(id);

        return "Event deleted";
    }
}