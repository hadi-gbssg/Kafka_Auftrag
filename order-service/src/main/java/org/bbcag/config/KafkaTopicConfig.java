package org.bbcag.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic ordersTopic() {
        return TopicBuilder
                .name(KafkaTopics.ORDERS)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic confirmationsTopic() {
        return TopicBuilder
                .name(KafkaTopics.ORDER_CONFIRMATIONS)
                .partitions(1)
                .replicas(1)
                .build();
    }
}