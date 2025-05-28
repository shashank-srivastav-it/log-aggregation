package com.backend.orderservice.request;

import com.backend.domain.generated.OrderStatus;
import com.backend.domain.generated.RecordType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDeleteDTO {
    private UUID id;
    private RecordType recordType;
}
