package dev.christiano.app;

import java.util.List;

import dev.christiano.model.User;
import dev.christiano.producer.FakeUserProducer;
import dev.christiano.producer.UserProducer;

public class App {
    public static void main(String[] args) {

        List<User> users = FakeUserProducer.batchFakeUser(10);

        for (User u : users) {
            UserProducer.publishUser(u);
        }

    }
}
