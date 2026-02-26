package com.example.loadbalancer.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.ServiceInstanceListSuppliers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier serviceInstanceListSupplier() {

        return ServiceInstanceListSuppliers.from(
                "api-service",

                new DefaultServiceInstance(
                        "instance1",
                        "api-service",
                        "localhost",
                        8081,
                        false
                ),
                new DefaultServiceInstance(
                        "instance2",
                        "api-service",
                        "localhost",
                        8082,
                        false
                )
        );
    }
}
