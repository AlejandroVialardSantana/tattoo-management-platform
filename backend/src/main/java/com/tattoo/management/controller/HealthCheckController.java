package com.tattoo.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Date;

@RestController
@RequestMapping("/v1/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> checkHealth() {
        Map<String, Object> response = Map.of(
            "status", "alive",
            "timestamp", new Date(),
            "apiVersion", "0.1.0",
            "environment", "Dockerized Development"
        );
        return ResponseEntity.ok(response);
    }
}