package counter;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class InitCounter {
    private final static String QUEUE_NAME = "counter";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queuePurge(QUEUE_NAME);
            System.out.println("The queue " + QUEUE_NAME + " has been killed successfully");
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, "0".getBytes("UTF-8"));
            System.out.println("Queue-----Initialized");
        }
    }
}
