package dev_rana.consumer_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer1(String message){
        log.info("Consumer1 consumer the message {} ",message);
    }

    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer2(String message){
        log.info("Consumer2 consumer the message {} ",message);
    }
    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer3(String message){
        log.info("Consumer3 consumer the message {} ",message);
    }
    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer4(String message){
        log.info("Consumer4 consumer the message {} ",message);
    }
    @KafkaListener(topics ="producer_topic_1",groupId = "consumer-group-1")
    public void consumer5(String message){
        log.info("Consumer5 consumer the message {} ",message);
    }
}
