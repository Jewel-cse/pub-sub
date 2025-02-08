package dev_rana.consumer_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer(String message){
        log.info("Consumer consumer the message {} ",message);
    }
}
