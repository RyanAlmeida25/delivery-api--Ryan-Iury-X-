package com.deliverytech.delivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now().toString(),
                "Service", "Delivery API - Atualizado com DevTools!"
        );
    }

    @GetMapping("/info")
    public ProjectInfo info() {
        return new ProjectInfo(
                "Delivery API",
                "1.0.0",
                "Ryan Iury Xavier Laranjeira de Almeida",
                "Java 21 + Spring Boot"
        );
    }

    public record ProjectInfo(
            String nome,
            String versao,
            String autor,
            String tecnologia
    ) {}

}