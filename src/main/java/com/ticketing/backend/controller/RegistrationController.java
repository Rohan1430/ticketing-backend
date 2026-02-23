package com.ticketing.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ticketing.backend.entity.Registration;
import com.ticketing.backend.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        return registrationRepository.save(registration);
    }

    @GetMapping
    public List<Registration> getAll() {
        return registrationRepository.findAll();
    }
}