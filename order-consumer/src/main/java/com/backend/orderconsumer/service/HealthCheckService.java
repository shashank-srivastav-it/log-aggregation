package com.backend.orderconsumer.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HealthCheckService {
    private final WebClient.Builder webClientBuilder;

    public HealthCheckService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public HttpStatus getHealthCheckStatus() {
        try {
            WebClient webClient = webClientBuilder.build();
            return webClient
                    .method(HttpMethod.GET)
                    .uri("http://localhost:8085/health-service")
                    .exchangeToMono(response -> {
                        if (response.statusCode().is2xxSuccessful()) {
                            return Mono.just(response.statusCode());
                        } else {
                            return Mono.just(HttpStatus.SERVICE_UNAVAILABLE);
                        }
                    }).block();
        } catch (Exception e) {
            return HttpStatus.SERVICE_UNAVAILABLE;
        }
    }
}
