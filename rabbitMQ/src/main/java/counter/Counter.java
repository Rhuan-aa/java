package counter;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Counter {
    private final static String QUEUE_NAME = "counter";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                int number = Integer.parseInt(message);

                System.out.println(" [x] Received: " + number);

                int newNumber = number + 1;

                channel.basicPublish("",
                        QUEUE_NAME,
                        null,
                        Integer.toString(newNumber).getBytes("UTF-8")
                );
                System.out.println(" [x] Sent " + newNumber);

                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

                try {
                    System.out.println("5 secs pause...");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Thread interrupted during sleep", e);
                }
            };

            channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {
            });
            System.out.println(" [*] Waiting for messages...");
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}