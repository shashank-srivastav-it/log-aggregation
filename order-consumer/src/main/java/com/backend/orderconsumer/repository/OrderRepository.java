package com.backend.orderconsumer.repository;

import com.backend.orderconsumer.entity.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEvent, UUID> {
}
