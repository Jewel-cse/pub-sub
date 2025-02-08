package dev_rana.producer_service.controller;

import dev_rana.producer_service.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 100000; i++) {
                kafkaMessagePublisher.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Message published");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
