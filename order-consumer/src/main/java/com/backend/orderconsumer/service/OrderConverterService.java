package com.backend.orderconsumer.service;

import com.backend.domain.generated.Order;
import com.backend.domain.generated.OrderItem;
import com.backend.domain.generated.OrderStatus;
import com.backend.orderconsumer.entity.Address;
import com.backend.orderconsumer.entity.OrderEvent;
import com.backend.orderconsumer.entity.Store;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderConverterService {
    public OrderEvent createOrder(Order order) {
        var orderEvent = mapOrderAvroToEntity(order);
        orderEvent.setId(order.getId());
        return orderEvent;
    }

    private OrderEvent mapOrderAvroToEntity(Order order) {
        var store = getAvroStoreToEntity(order);
        var orderItems = buildAvroOrderItemsToEntity(order.getOrderItems());
        return OrderEvent.builder().
                customerName(order.getCustomerName().toString()).
                customerEmail(order.getCustomerEmail().toString()).
                store(store).
                orderItems(orderItems).
                orderedTime(order.getOrderedTime().atZone(ZoneId.systemDefault()).toLocalDateTime()).
                pickUp(order.getPickUp()).
                status(OrderStatus.valueOf(order.getStatus().toString())).
                build();
    }

    private Store getAvroStoreToEntity(Order order) {
        var store = order.getStore();
        return Store.builder()
                .id(store.getId())
                .address(new Address(store.getAddress().getAddressLine1().toString(),
                        store.getAddress().getCity().toString(),
                        store.getAddress().getState().toString(),
                        store.getAddress().getCountry().toString(),
                        store.getAddress().getZip().toString()))
                .build();
    }

    private List<com.backend.orderconsumer.entity.OrderItem> buildAvroOrderItemsToEntity(List<OrderItem> orderAvroItems) {
        return orderAvroItems
                .stream()
                .map(orderItemAvro -> new com.backend.orderconsumer.entity.OrderItem(
                        orderItemAvro.getName().toString(),
                        orderItemAvro.getSize(),
                        orderItemAvro.getQuantity(),
                        orderItemAvro.getCost()))
                .collect(Collectors.toList());
    }
}
