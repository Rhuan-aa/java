package com.rhuanaab.rabbitmqcounter;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CounterConsumers {

    private final CounterService counterService;

    public CounterConsumers(CounterService counterService) {
        this.counterService = counterService;
    }

    // Entidade 1
    @RabbitListener(queues = RabbitMQConfig.COUNTER_QUEUE, concurrency = "1")
    public void entityOneListener(String message) {
        System.out.println("Entidade 1 recebendo mensagem: " + message);
        int newCount = counterService.increment();
        System.out.println("Entidade 1: Contador incrementado. Valor atual: " + newCount);
    }

    // Entidade 2
    @RabbitListener(queues = RabbitMQConfig.COUNTER_QUEUE, concurrency = "1")
    public void entityTwoListener(String message) {
        System.out.println("Entidade 2 recebendo mensagem: " + message);
        int newCount = counterService.increment();
        System.out.println("Entidade 2: Contador incrementado. Valor atual: " + newCount);
    }
}