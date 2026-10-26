package org.bbcag.consumer;

import org.bbcag.config.KafkaTopics;
import org.bbcag.dto.OrderConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(ConfirmationConsumer.class);

    @KafkaListener(
            topics = KafkaTopics.ORDER_CONFIRMATIONS,
            groupId = "order-service"
    )
    public void receiveConfirmation(
            OrderConfirmation confirmation) {

        log.info(
                "Bestätigung empfangen orderId={} status={}",
                confirmation.orderId(),
                confirmation.status()
        );
    }
}