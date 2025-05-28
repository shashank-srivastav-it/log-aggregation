package com.backend.orderconsumer;

import com.backend.orderconsumer.service.HealthCheckService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OrderConsumerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(OrderConsumerApplication.class, args);
        HealthCheckService healthCheckService = applicationContext.getBean(HealthCheckService.class);
        System.out.println("System Status "+healthCheckService.getHealthCheckStatus().is2xxSuccessful());
    }
}