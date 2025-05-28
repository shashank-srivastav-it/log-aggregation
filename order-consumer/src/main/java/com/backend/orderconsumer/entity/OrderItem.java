package com.backend.orderconsumer.entity;

import com.backend.domain.generated.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private Size size;
    private Integer quantity;
    private BigDecimal cost;

    public OrderItem(String name, Size size, Integer quantity, BigDecimal cost) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.cost = cost;
    }
}
