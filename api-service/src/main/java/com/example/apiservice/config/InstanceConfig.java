package com.example.apiservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class InstanceConfig {
    @Value("${server.port}")
    private String port;

    @Value("${instance.name}")
    private String instanceName;
}

