package com.backend.ksqldbservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ksql")
public class KsqlProperties {
    private String server;
    private Integer port;
    private String apiKey;
    private String apiSecret;
    private String query;
}
