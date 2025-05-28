package com.backend.orderservice.request;

import com.backend.domain.generated.PickUp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private String id;
    private String customerName;
    private String customerEmail;
    private String message;
    private StoreDTO store;
    private List<OrderItemDTO> orderItems;
    private PickUp pickUp;
    private String status;
    private LocalDateTime orderedTime;
}
