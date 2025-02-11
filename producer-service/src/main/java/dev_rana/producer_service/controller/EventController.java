package dev_rana.producer_service.controller;

import dev.rana.dto.Customer;
import dev_rana.producer_service.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 1000000; i++) {
                kafkaMessagePublisher.sendMessageToTopic(message + " : " + i);
            }
            return ResponseEntity.ok("Message published");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/publish-obj")
    public ResponseEntity<?> publishObject(@RequestBody Customer customer) {
        try {
            for (int i = 0; i < 300000; i++) {
                kafkaMessagePublisher.sendObjectToTopic(customer);
            }
            return ResponseEntity.ok("Object send successfully");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
