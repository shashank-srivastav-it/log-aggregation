package com.backend.orderconsumer.consumer;

import com.backend.domain.generated.Order;
import com.backend.domain.generated.OrderDeleteEvent;
import com.backend.domain.generated.OrderUpdateEvent;
import com.backend.domain.generated.RecordType;
import com.backend.orderconsumer.entity.OrderEvent;
import com.backend.orderconsumer.service.OrderEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer implements AcknowledgingMessageListener<String, GenericRecord> {

    @Autowired
    private OrderEventsService orderEventsService;

    @Override
    @KafkaListener(topics = {"order"}, groupId = "${spring.kafka.consumer.group-id}")
    public void onMessage(ConsumerRecord<String, GenericRecord> consumerRecord, Acknowledgment acknowledgment) {
        log.info("ConsumerRecord key : {} , value {}", consumerRecord.key(), consumerRecord.value());
        var genericRecord = consumerRecord.value();
        var recordType = RecordType.valueOf(genericRecord.get("recordType").toString());

        switch (recordType) {
            case CREATE_ORDER:
                Order order = (Order) genericRecord;
                log.info("Create Order Event: {}", order);
                orderEventsService.processOrderEvent(order, acknowledgment);
                break;
            case UPDATE_ORDER:
                OrderUpdateEvent orderUpdateEvent = (OrderUpdateEvent) genericRecord;
                log.info("Update Order Event: {}", orderUpdateEvent);
                OrderEvent validEvent = orderEventsService.validate(genericRecord);
                orderEventsService.updateOrderEvent(orderUpdateEvent, validEvent, acknowledgment);
                break;
            case DELETE_ORDER:
                OrderDeleteEvent orderDeleteEvent = (OrderDeleteEvent) genericRecord;
                log.info("Delete Order Event: {}", orderDeleteEvent);
                orderEventsService.validate(genericRecord);
                orderEventsService.deleteOrderEvent(orderDeleteEvent, acknowledgment);
                break;
            default:
                log.info("Invalid Order Event: {}", genericRecord);
                break;
        }
    }
}
