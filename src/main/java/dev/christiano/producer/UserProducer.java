package dev.christiano.producer;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;

import dev.christiano.model.User;

public class UserProducer {

    public static String publishUser(User user) {
        try {
            PulsarClient client = PulsarClient.builder()
                    .serviceUrl("pulsar://localhost:6650")
                    .build();

            Producer<User> producer = client.newProducer(JSONSchema.of(User.class))
                    .topic("users-topic")
                    .create();

            producer.send(user);
            producer.close();
            client.close();

            return ("Message sent ");
        } catch (PulsarClientException e) {
            return ("Error " + e);
        } 
    }

}
