package dev_rana.producer_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {


    @Bean
    public NewTopic createTopic() {
        return new NewTopic("producer_topic_1", 5, (short) 1);
    }

}
