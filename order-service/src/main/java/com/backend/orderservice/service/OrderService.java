package com.backend.orderservice.service;

import com.backend.domain.generated.*;
import com.backend.orderservice.producers.OrderDeleteProducer;
import com.backend.orderservice.producers.OrderProducer;
import com.backend.orderservice.producers.OrderUpdateProducer;
import com.backend.orderservice.request.OrderDTO;
import com.backend.orderservice.request.OrderDeleteDTO;
import com.backend.orderservice.request.OrderItemDTO;
import com.backend.orderservice.request.OrderUpdateDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderProducer orderProducer;
    private OrderUpdateProducer orderUpdateProducer;
    private OrderDeleteProducer orderDeleteProducer;

    public OrderDTO createOrder(OrderDTO orderDTO) {
        var orderEvent = mapToOrder(orderDTO);
        orderDTO.setId(orderEvent.getId().toString());
        orderProducer.sendMessage(orderEvent);
        return orderDTO;
    }

    public OrderUpdateDTO updateOrder(String orderId, OrderUpdateDTO orderUpdateDTO) {
        var orderUpdateEvent = mapToOrderUpdate(orderId, orderUpdateDTO);
        orderUpdateProducer.sendMessage(orderUpdateEvent);
        return orderUpdateDTO;
    }

    public OrderDeleteDTO deleteOrder(String orderId) {
        var orderDeleteEvent = OrderDeleteEvent
                .newBuilder()
                .setId(UUID.fromString(orderId))
                .build();
        orderDeleteProducer.sendMessage(orderDeleteEvent);
        return new OrderDeleteDTO(orderDeleteEvent.getId(), orderDeleteEvent.getRecordType());
    }

    private Order mapToOrder(OrderDTO orderDTO) {
        var store = getStore(orderDTO);
        var orderItems = buildOrderItems(orderDTO.getOrderItems());

        return Order
                .newBuilder()
                .setId(UUID.randomUUID())
                .setCustomerName(orderDTO.getCustomerName())
                .setCustomerEmail(orderDTO.getCustomerEmail())
                .setStore(store)
                .setOrderItems(orderItems)
                .setOrderedTime(Instant.now())
                .setPickUp(orderDTO.getPickUp())
                .setStatus(orderDTO.getStatus())
                .build();
    }

    private List<OrderItem> buildOrderItems(List<OrderItemDTO> orderItems) {
        return orderItems
                .stream()
                .map(orderItemDTO -> new OrderItem(orderItemDTO.getName(),
                        orderItemDTO.getSize(),
                        orderItemDTO.getQuantity(),
                        orderItemDTO.getCost())
                )
                .collect(Collectors.toList());
    }


    private Store getStore(OrderDTO orderDTO) {
        var store = orderDTO.getStore();
        return Store
                .newBuilder()
                .setId(store.getStoreId())
                .setAddress(
                        new Address(store.getAddress().getAddressLine1(),
                                store.getAddress().getCity(),
                                store.getAddress().getState(),
                                store.getAddress().getCountry(),
                                store.getAddress().getZip())
                )
                .build();
    }

    private OrderUpdateEvent mapToOrderUpdate(String orderId, OrderUpdateDTO orderUpdateDTO) {
        return OrderUpdateEvent
                .newBuilder()
                .setId(UUID.fromString(orderId))
                .setStatus(orderUpdateDTO.getOrderStatus())
                .build();
    }
}
