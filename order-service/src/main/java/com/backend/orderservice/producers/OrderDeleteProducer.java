package com.backend.orderservice.producers;

import com.backend.domain.generated.OrderDeleteEvent;
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
public class OrderDeleteProducer {

    private KafkaTemplate<String, OrderDeleteEvent> kafkaTemplate;

    public void sendMessage(OrderDeleteEvent orderAvro) {

        ProducerRecord<String, OrderDeleteEvent> producerRecord = new ProducerRecord<String, OrderDeleteEvent>("order", orderAvro.getId().toString(), orderAvro);
        ListenableFuture<SendResult<String, OrderDeleteEvent>> listenableFuture = kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<String, OrderDeleteEvent>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(orderAvro, ex);
            }

            @Override
            public void onSuccess(SendResult<String, OrderDeleteEvent> result) {
                handleSuccess(orderAvro, result);
            }
        });
    }

    private void handleFailure(OrderDeleteEvent orderAvro, Throwable ex) {
        log.error("Error Sending the message for {} and the exception is : {}", orderAvro
                , ex.getMessage(), ex);
    }

    private void handleSuccess(OrderDeleteEvent orderAvro, SendResult<String, OrderDeleteEvent> result) {
        log.info("Message sent successfully for the key : {} , and the value is {}" +
                ", partition is {}", orderAvro.getId(), orderAvro, result.getRecordMetadata()
                .partition());
    }
}
