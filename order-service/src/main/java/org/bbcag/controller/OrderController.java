package org.bbcag.controller;

import jakarta.validation.Valid;
import org.bbcag.dto.OrderRequest;
import org.bbcag.producer.OrderProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger log =
            LoggerFactory.getLogger(OrderController.class);

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(
            @Valid @RequestBody OrderRequest order) {

        log.info(
                "REST-Aufruf empfangen orderId={}",
                order.orderId()
        );

        orderProducer.sendOrder(order);

        return ResponseEntity.accepted().build();
    }
}