package com.backend.orderservice.request;

import com.backend.domain.generated.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderUpdateDTO {
    private OrderStatus orderStatus;
}
