package com.example.apiservice.controller;

import com.example.apiservice.config.InstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiServiceController {


    private final InstanceConfig instanceConfig;

    @Autowired
    public ApiServiceController(InstanceConfig instanceConfig) {
        this.instanceConfig = instanceConfig;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> hello() {

        String response = String.format("Hello from instance '%s' running on port %s", instanceConfig.getInstanceName(), instanceConfig.getPort());
        return ResponseEntity.ok(response);

    }
}
