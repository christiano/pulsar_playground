package dev.christiano.consumer;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.impl.schema.JSONSchema;

import dev.christiano.model.User;

public class FakeUserConsumer {

    public static void ConsumerUser() {

        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://localhost:6650")
                    .build();

            Consumer<User> consumer = client.newConsumer(JSONSchema.of(User.class))
                    .topic("users-topic")
                    .subscriptionName("javacli")
                    .subscribe();

            while (true) {
                Message<User> msg = consumer.receive();

                try {
                    // System.out.println("Message " + new String(msg.getData()));
                    
                    System.out.println(msg.getValue().toString());
                    consumer.acknowledge(msg);
                } catch (Exception e) {
                    consumer.negativeAcknowledge(msg);
                    System.out.println("Error " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error with the client");
        }

    }

}
