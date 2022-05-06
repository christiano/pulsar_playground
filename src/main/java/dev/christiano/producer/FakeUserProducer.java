package dev.christiano.producer;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

import dev.christiano.model.User;

public class FakeUserProducer {

    public static User oneFakeUser() {
        Faker faker = new Faker();

        User user = new User(faker.name().firstName(), faker.name().lastName(), faker.address().city(),
                faker.address().country());

        return (user);
    }

    public static List<User> batchFakeUser(int count) {

        Faker faker = new Faker();

        List<User> users = new ArrayList<User>(count);

        for (int i = 0; i < count; i++) {
            User user = new User(faker.name().firstName(), faker.name().lastName(), faker.address().city(),
                    faker.address().country());
            users.add(user);
        }

        return (users);

    }

}
