package com.backend.orderservice.producers;

import com.backend.domain.generated.OrderUpdateEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
@AllArgsConstructor
public class OrderUpdateProducer {

    private KafkaTemplate<String, OrderUpdateEvent> kafkaTemplate;

    public void sendMessage(OrderUpdateEvent orderAvro) {

        ProducerRecord<String, OrderUpdateEvent> producerRecord = new ProducerRecord<String, OrderUpdateEvent>("order", orderAvro.getId().toString(), orderAvro);
        ListenableFuture<SendResult<String, OrderUpdateEvent>> listenableFuture = kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, OrderUpdateEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(orderAvro, ex);
            }

            @Override
            public void onSuccess(SendResult<String, OrderUpdateEvent> result) {
                handleSuccess(orderAvro, result);
            }
        });
    }

    private void handleFailure(OrderUpdateEvent orderAvro, Throwable ex) {
        log.error("Error Sending the message for {} and the exception is : {}", orderAvro
                , ex.getMessage(), ex);
    }

    private void handleSuccess(OrderUpdateEvent orderAvro, SendResult<String, OrderUpdateEvent> result) {
        log.info("Message sent successfully for the key : {} , and the value is {}" +
                ", partition is {}", orderAvro.getId(), orderAvro, result.getRecordMetadata()
                .partition());
    }
}
