package org.bbcag.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "received_orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;

    private String customer;

    private BigDecimal amount;

    private LocalDateTime receivedAt;

    public OrderEntity() {
    }

    public OrderEntity(
            String orderId,
            String customer,
            BigDecimal amount,
            LocalDateTime receivedAt) {

        this.orderId = orderId;
        this.customer = customer;
        this.amount = amount;
        this.receivedAt = receivedAt;
    }

    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }
}