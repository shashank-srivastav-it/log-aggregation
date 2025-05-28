package com.backend.orderservice.controller;

import com.backend.orderservice.request.OrderDTO;
import com.backend.orderservice.request.OrderDeleteDTO;
import com.backend.orderservice.request.OrderUpdateDTO;
import com.backend.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("order")
public class OrderController {

    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        log.info("Received the request for an order : {}", orderDTO);
        return orderService.createOrder(orderDTO);
    }

    @PutMapping("/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderUpdateDTO updateOrder(@PathVariable("order_id") String orderId,
                                      @RequestBody OrderUpdateDTO orderUpdateDTO) {
        return orderService.updateOrder(orderId, orderUpdateDTO);
    }

    @DeleteMapping("/{order_id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDeleteDTO deleteOrder(@PathVariable("order_id") String orderId) {
        return orderService.deleteOrder(orderId);
    }
}
