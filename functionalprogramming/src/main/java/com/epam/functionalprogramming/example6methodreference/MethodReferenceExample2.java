package com.epam.functionalprogramming.example6methodreference;

import java.time.LocalTime;
import java.util.function.Supplier;

public class MethodReferenceExample2 {

    public static void main(String[] args) {
        //create two Person instances

        //printGreetings from first Person by firstName

        //printGreetings from second Person by lastName

        //printGreetings from first Person by fullName

        //printGreetings from Sofia city
    }

    private static void printGreetings(Supplier<String> fromSupplier) {
        if (LocalTime.now().getHour() < 21) { //a bad example of a function
            System.out.println("Greetings from " + fromSupplier.get());
        } else {
            System.out.println("Too late for greetings ");
        }
    }

    private static class City {

        private final String name;

        City(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    private static class Person {

        private final String firstName;
        private final String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }

        String fullName() {
            return firstName + " " + lastName;
        }
    }
}
