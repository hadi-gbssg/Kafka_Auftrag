package org.bbcag.producer;

import org.bbcag.config.KafkaTopics;
import org.bbcag.dto.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger log =
            LoggerFactory.getLogger(OrderProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(OrderRequest order) {

        kafkaTemplate.send(
                KafkaTopics.ORDERS,
                order.orderId(),
                order
        );

        log.info(
                "Nachricht versendet orderId={}",
                order.orderId()
        );
    }
}