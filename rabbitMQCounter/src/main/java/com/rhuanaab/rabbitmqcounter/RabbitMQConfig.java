package com.rhuanaab.rabbitmqcounter;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    public static final String COUNTER_QUEUE = "counterQueue";

    @Bean
    public Queue counterQueue() {
        return new Queue(COUNTER_QUEUE);
    }
}
