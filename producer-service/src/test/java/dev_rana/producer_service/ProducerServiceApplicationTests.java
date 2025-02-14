package dev_rana.producer_service;

import dev.rana.dto.Customer;
import dev_rana.producer_service.service.KafkaMessagePublisher;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.ConfluentKafkaContainer;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class ProducerServiceApplicationTests {

    @Container
    static ConfluentKafkaContainer kafka = new ConfluentKafkaContainer("confluentinc/cp-kafka:7.4.0");

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @DynamicPropertySource
    public static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Test
    @Order(1)
    public void testSendMessageToTopic() {
        kafkaMessagePublisher.sendMessageToTopic("This is a test message");

        await().pollInterval(Duration.ofSeconds(3))
                .atMost(60, SECONDS)
                .untilAsserted(() -> {
                    System.out.println("Message sent successfully.");
                });
    }

    @Test
    @Order(2)
    public void testSendObjectToTopic() {
        Customer customer = new Customer("Jewel test","jewel-test@mail.com");
        kafkaMessagePublisher.sendObjectToTopic(customer);

        await().pollInterval(Duration.ofSeconds(3))
                .atMost(60, SECONDS)
                .untilAsserted(() -> {
                    System.out.println("Message sent successfully.");
                });
    }

    @Test
    @Order(3)
    public void testSendMessageTOPartition() {
        kafkaMessagePublisher.sendMessageTOPartition();
        await().pollInterval(Duration.ofSeconds(3))
                .atMost(60, SECONDS)
                .untilAsserted(() -> {
                    System.out.println("Message sent successfully.");
                });
    }

}
