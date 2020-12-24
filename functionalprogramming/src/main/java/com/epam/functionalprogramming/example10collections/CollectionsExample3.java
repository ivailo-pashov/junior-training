package com.epam.functionalprogramming.example10collections;

import java.util.Comparator;

public class CollectionsExample3 {

    public static void main(String[] args) {
        //declare a list of 5 people

        //sort by firstName ASC and print to console

        //sort by lastName DESC, age ASC and print to console
        
        //ORDER BY age DESC, first_name ASC
        Comparator.comparing(Person::getAge).reversed()
            .thenComparing(Person::getFirstName);
        
    }

    private static class Person {

        private final String firstName;
        private final String lastName;
        private final int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }
    }
}
