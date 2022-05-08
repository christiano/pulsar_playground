package dev.christiano.consumer;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;

public class FakeUserConsumer {

    public static void ConsumerUser() {

        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://localhost:6650")
                    .build();

            Consumer consumer = client.newConsumer()
                    .topic("users-topic")
                    .subscriptionName("javacli")
                    .subscribe();

            while (true) {
                Message msg = consumer.receive();

                try {
                    System.out.println("Message " + new String(msg.getData()));
                    consumer.acknowledge(msg);
                } catch (Exception e) {
                    consumer.negativeAcknowledge(msg);
                    System.out.println("Error");
                }
            }

        } catch (Exception e) {
            System.out.println("Error with the client");
        }

    }

}
