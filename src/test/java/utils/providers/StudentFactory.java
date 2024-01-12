package utils.providers;

import models.Student;
import net.datafaker.Faker;

import java.text.SimpleDateFormat;

public class StudentFactory {

    public static Student getRandomStudent() {
        Faker faker = new Faker();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return Student.builder()
                .first_name(faker.name().firstName())
                .middle_name(faker.name().firstName())
                .last_name(faker.name().lastName())
                .date_of_birth(format.format(faker.date().birthday()))
                .build();
    }

    public static String getRandomName(){
        return new Faker().name().firstName();
    }
}
