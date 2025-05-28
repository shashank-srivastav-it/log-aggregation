package com.backend.orderconsumer.entity;

import com.backend.domain.generated.OrderStatus;
import com.backend.domain.generated.PickUp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    private String customerName;
    private String customerEmail;
    private String message;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;
    private PickUp pickUp;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime orderedTime;
}
