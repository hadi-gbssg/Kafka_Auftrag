package org.bbcag.controller;

import org.bbcag.entity.OrderEntity;
import org.bbcag.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/confirmations")
public class ConfirmationController {

    private final OrderRepository orderRepository;

    public ConfirmationController(
            OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<OrderEntity> getOrders() {
        return orderRepository.findAll();
    }
}