package com.rhuanaab.rabbitmqcounter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enviando mensagens para a fila de contagem...");
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.COUNTER_QUEUE, "Incrementar o contador");
            Thread.sleep(1000); // Pausa para ver os logs
        }
    }
}
