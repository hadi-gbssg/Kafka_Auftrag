package org.bbcag.producer;

import org.bbcag.config.KafkaTopics;
import org.bbcag.dto.OrderConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationProducer {

    private static final Logger log =
            LoggerFactory.getLogger(ConfirmationProducer.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ConfirmationProducer(
            KafkaTemplate<String, Object> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendConfirmation(
            OrderConfirmation confirmation) {

        kafkaTemplate.send(
                KafkaTopics.ORDER_CONFIRMATIONS,
                confirmation.orderId(),
                confirmation
        );

        log.info(
                "Bestätigung versendet orderId={}",
                confirmation.orderId()
        );
    }
}