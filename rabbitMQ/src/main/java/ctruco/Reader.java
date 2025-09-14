package ctruco;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Reader {
    private static final String QUEUE_NAME = "game";

    public void start() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages in '" + QUEUE_NAME + "'...");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            try {
                String json = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Raw message: " + json);
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            } catch (Exception e) {
                e.printStackTrace();
                channel.basicNack(delivery.getEnvelope().getDeliveryTag(), false, true);
            }
        };
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> { });
    }
}
