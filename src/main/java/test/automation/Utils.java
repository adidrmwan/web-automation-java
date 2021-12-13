package test.automation;

import com.github.javafaker.Faker;

public class Utils {
    public String getRandomFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }
}
