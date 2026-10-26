package org.bbcag.service;

import org.bbcag.dto.OrderConfirmation;
import org.bbcag.dto.OrderRequest;
import org.bbcag.entity.OrderEntity;
import org.bbcag.producer.ConfirmationProducer;
import org.bbcag.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConfirmationService {

    private static final Logger log =
            LoggerFactory.getLogger(ConfirmationService.class);

    private final OrderRepository orderRepository;
    private final ConfirmationProducer confirmationProducer;

    public ConfirmationService(
            OrderRepository orderRepository,
            ConfirmationProducer confirmationProducer) {

        this.orderRepository = orderRepository;
        this.confirmationProducer = confirmationProducer;
    }

    public void processOrder(OrderRequest order) {

        try {

            OrderEntity entity = new OrderEntity(
                    order.orderId(),
                    order.customer(),
                    order.amount(),
                    LocalDateTime.now()
            );

            orderRepository.save(entity);

            log.info(
                    "Bestellung erfolgreich gespeichert orderId={}",
                    order.orderId()
            );

            OrderConfirmation confirmation =
                    new OrderConfirmation(
                            order.orderId(),
                            "CONFIRMED"
                    );

            confirmationProducer.sendConfirmation(
                    confirmation
            );

        } catch (Exception exception) {

            log.error(
                    "Fehler bei Speicherung orderId={}",
                    order.orderId(),
                    exception
            );

            throw exception;
        }
    }
}