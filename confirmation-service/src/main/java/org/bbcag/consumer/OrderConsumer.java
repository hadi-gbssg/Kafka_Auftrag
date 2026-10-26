package org.bbcag.consumer;

import org.bbcag.config.KafkaTopics;
import org.bbcag.dto.OrderRequest;
import org.bbcag.service.ConfirmationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(OrderConsumer.class);

    private final ConfirmationService confirmationService;

    public OrderConsumer(
            ConfirmationService confirmationService) {

        this.confirmationService =
                confirmationService;
    }

    @KafkaListener(
            topics = KafkaTopics.ORDERS,
            groupId = "confirmation-service"
    )
    public void receiveOrder(OrderRequest order) {

        log.info(
                "Bestellung empfangen orderId={}",
                order.orderId()
        );

        confirmationService.processOrder(order);
    }
}