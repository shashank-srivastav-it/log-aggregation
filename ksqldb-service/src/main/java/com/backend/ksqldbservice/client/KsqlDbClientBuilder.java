package com.backend.ksqldbservice.client;

import com.backend.ksqldbservice.config.KsqlProperties;
import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class KsqlDbClientBuilder {

    private final KsqlProperties ksqlProperties;
    private final Client client;

    @Autowired
    public KsqlDbClientBuilder(KsqlProperties ksqlProperties) {
        this.ksqlProperties = ksqlProperties;
        this.client = buildClient();
    }

    private Client buildClient() {
        ClientOptions options = loadClientConfig();
        return Client.create(options);
    }

    private ClientOptions loadClientConfig() {
        return ClientOptions.create()
                .setHost(ksqlProperties.getServer())
                .setPort(ksqlProperties.getPort())
                .setBasicAuthCredentials(ksqlProperties.getApiKey(), ksqlProperties.getApiSecret())
                .setUseTls(true)
                .setUseAlpn(true);
    }

    public List<Row> fetchQueryResults(String query) throws ExecutionException, InterruptedException {
        return client.executeQuery(query).get();
    }
}
