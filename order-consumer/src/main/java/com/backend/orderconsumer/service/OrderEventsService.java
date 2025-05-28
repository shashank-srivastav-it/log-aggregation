package com.backend.orderconsumer.service;

import com.backend.domain.generated.Order;
import com.backend.domain.generated.OrderDeleteEvent;
import com.backend.domain.generated.OrderUpdateEvent;
import com.backend.orderconsumer.entity.OrderEvent;
import com.backend.orderconsumer.repository.AddressRepository;
import com.backend.orderconsumer.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.dao.RecoverableDataAccessException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class OrderEventsService {

    private OrderRepository orderRepository;
    private AddressRepository addressRepository;
    private OrderConverterService orderConverterService;
    private HealthCheckService healthCheckService;

    public void processOrderEvent(Order order, Acknowledgment acknowledgment) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        OrderEvent orderEntity = orderConverterService.createOrder(order);
        save(orderEntity);
        log.info("Successfully Persisted the order Event {} ", order);
        acknowledgment.acknowledge();
    }

    public void updateOrderEvent(OrderUpdateEvent orderUpdateEvent, OrderEvent orderEvent, Acknowledgment acknowledgment) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        orderEvent.setStatus(orderUpdateEvent.getStatus());
        save(orderEvent);
        log.info("Successfully Updated the order Event {} ", orderUpdateEvent);
//        acknowledgment.acknowledge();
    }

    public void deleteOrderEvent(OrderDeleteEvent orderDeleteEvent, Acknowledgment acknowledgment) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        orderRepository.deleteById(orderDeleteEvent.getId());
        log.info("Successfully Deleted the order Event {} ", orderDeleteEvent);
//        acknowledgment.acknowledge();
    }

    public void processOrderEvent(Order order) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        OrderEvent orderEntity = orderConverterService.createOrder(order);
        save(orderEntity);
        log.info("Successfully Persisted the order Event {} ", order);
    }

    public void updateOrderEvent(OrderUpdateEvent orderUpdateEvent, OrderEvent orderEvent) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        orderEvent.setStatus(orderUpdateEvent.getStatus());
        save(orderEvent);
        log.info("Successfully Updated the order Event {} ", orderUpdateEvent);
    }

    public void deleteOrderEvent(OrderDeleteEvent orderDeleteEvent) {
        if (!healthCheckService.getHealthCheckStatus().is2xxSuccessful()) {
            throw new RecoverableDataAccessException("Service Unavailable");
        }
        orderRepository.deleteById(orderDeleteEvent.getId());
        log.info("Successfully Deleted the order Event {} ", orderDeleteEvent);
    }

    public OrderEvent validate(GenericRecord genericRecord) {
        Optional<OrderEvent> orderOptional = orderRepository.findById(UUID.fromString(genericRecord.get("id").toString()));
        if (orderOptional.isEmpty()) {
            throw new IllegalArgumentException("Not a valid library Event");
        }
        log.info("Validation is successful for the Event : {} ", orderOptional.get());
        return orderOptional.get();
    }

    private void save(OrderEvent order) {
        addressRepository.save(order.getStore().getAddress());
        orderRepository.save(order);
    }
}
