package dev.christiano.app;

import java.util.List;

import dev.christiano.consumer.FakeUserConsumer;
import dev.christiano.model.User;
import dev.christiano.producer.FakeUserProducer;
import dev.christiano.producer.UserProducer;

public class App {
    public static void main(String[] args) {

        if (args.length < 1) {

            System.out.println("Please enter an option: ");
            System.out.println("producer or consumer");

            System.exit(1);
        } else {
            String firstArg = args[0].toString();
            System.out.println("You entered " + firstArg);

            if (firstArg.equals("consumer")) {
                System.out.println("Starting the consumer");
                FakeUserConsumer.ConsumerUser();
                System.exit(0);
            }
            
            if (firstArg.equals("producer")) {
                System.out.println("Starting the producer");
                pushUsers();
                System.exit(0);
            } else {
                System.out.println("Valid options: producer or consumer");
                System.exit(1);
            }
        }

    }

    public static void pushUsers() {

        System.out.println("Staring to publish users...");

        List<User> users = FakeUserProducer.batchFakeUser(10);

        for (User u : users) {
            UserProducer.publishUser(u);
            System.out.println("Ingested: " + u);
        }

        System.out.println("Ingestion done!");
    }

}
