package com.myfirstproject;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class Day04_JavaFaker {
    /*
    Java Faker class is used for fake test data

    Intvw Q: Where do you get your test data from?
    - BA (They write the acceptance criteria)
    - Test Lead
    - Manual Tester
    - Developer
    - Database call
    - API calls
    - Most commonly Java Faker class is used for test data (if company allows)
       It generate data randomly

     */
    @Test
    public void javaFakerTest(){
        Faker faker = new Faker();

//        First name
        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

//        Last Name
        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String funnyName = faker.funnyName().name();
        System.out.println("funnyName = " + funnyName);

        // title
        System.out.println(faker.name().title());

        // city
        System.out.println(faker.address().city());
        // State
        System.out.println(faker.address().state());
        // Full address
        System.out.println(faker.address().fullAddress());
        //Zip code
        System.out.println(faker.address().zipCode());

        // Phone number
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());

        // Email
        System.out.println(faker.internet().emailAddress());

        // Random digits
        System.out.println(faker.number().digit());
        System.out.println(faker.number().numberBetween(1000, 30000));

        System.out.println(faker.internet().image());
        System.out.println(faker.internet().avatar());


    }
}
