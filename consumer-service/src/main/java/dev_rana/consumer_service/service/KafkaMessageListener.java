package dev_rana.consumer_service.service;

import dev.rana.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    //message listen
    @KafkaListener(topics = "producer_topic_1", groupId = "consumer-group-1")
    public void consumer1(String message) {
        log.info("Consumer1 consumer the message {} ", message);
    }

    @KafkaListener(topics = "producer_topic_1", groupId = "consumer-group-1")
    public void consumer2(String message) {
        log.info("Consumer2 consumer the message {} ", message);
    }

    @KafkaListener(topics = "producer_topic_1", groupId = "consumer-group-1")
    public void consumer3(String message) {
        log.info("Consumer3 consumer the message {} ", message);
    }

    @KafkaListener(topics = "producer_topic_1", groupId = "consumer-group-1")
    public void consumer4(String message) {
        log.info("Consumer4 consumer the message {} ", message);
    }

    @KafkaListener(topics = "producer_topic_1", groupId = "consumer-group-1")
    public void consumer5(String message) {
        log.info("Consumer5 consumer the message {} ", message);
    }

    //object received
    @KafkaListener(topics = "object-send-topic", groupId = "consumer-object-group-1")
    public void consumerObj1(Customer customer) {
        log.info("ConsumerObj1 consume the object {} ", customer.toString());
    }

    @KafkaListener(topics = "object-send-topic", groupId = "consumer-object-group-1")
    public void consumerObj2(Customer customer) {
        log.info("ConsumerObj2 consume the object {} ", customer.toString());
    }

    @KafkaListener(topics = "object-send-topic", groupId = "consumer-object-group-1")
    public void consumerObj3(Customer customer) {
        log.info("ConsumerObj3 consume the object {} ", customer.toString());
    }

    //listen from specific partitions

    @KafkaListener(topics = "topic_specific_partition", groupId = "specific_partitions_listener",
            topicPartitions = {@TopicPartition(topic = "topic_specific_partition", partitions = {"1"})})
    public void specificPartition(String message) {
        log.info("specificPartition consume the Message: {} ", message);
    }

}
