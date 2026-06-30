package com.tattoo.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.tattoo.management.dto.AppointmentRequestDTO;
import com.tattoo.management.dto.AppointmentResponseDTO;
import com.tattoo.management.service.AppointmentService;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponseDTO create(@Valid @RequestBody AppointmentRequestDTO request) {
        return service.createAppointment(request);
    }
}