package com.example.loadbalancer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancerController {

    private final RestTemplate restTemplate;

    public LoadBalancerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> callApiService() {

        String response = restTemplate.getForObject(
                "http://api-service/api/hello",
                String.class
        );
        return ResponseEntity.ok(response);
    }
}
