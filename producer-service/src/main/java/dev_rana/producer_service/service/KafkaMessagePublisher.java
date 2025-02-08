package dev_rana.producer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToTopic(String message) {
        //spring will automatically create a topic for given name
        CompletableFuture<SendResult<String,Object>> future = kafkaTemplate.send("producer_topic_1",message);
        future.whenComplete((result,exception) -> {
            if(exception != null) {
                System.out.println("Unable to send message "+message+ "because "+exception.getMessage());
            }else{
                System.out.println("Message :"+
                        message+" is sent with offset :"+
                        result.getRecordMetadata().offset());
            }
        });
    }
}
