package com.epam.functionalprogramming.example6methodreference;

import java.util.Objects;

public class MethodReferenceExample3Bouns {

    public static void main(String[] args) {
        Person person = new Person("ivan", "IVANoV");

        updateFirstName(person);
        updateLastName(person);
        System.out.println(person.fullName());

        City city = new City("SOfIA");
        updateName(city);
        System.out.println(city.getName());
    }

    private static void updateName(City city) {
        if (city == null) {
            return;
        }
        String name = city.getName();
        if (name == null || name.isEmpty()) {
            return;
        }
        if (name.length() > 10) {
            name = name.substring(0, 10);
        }
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        if (!Objects.equals(name, city.getName())) {
            city.setName(name);
        }
    }

    private static void updateFirstName(Person person) {
        if (person == null) {
            return;
        }
        String name = person.getFirstName();
        if (name == null || name.isEmpty()) {
            return;
        }
        if (name.length() > 10) {
            name = name.substring(0, 10);
        }
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        if (!Objects.equals(name, person.getFirstName())) {
            person.setFirstName(name);
        }
    }

    private static void updateLastName(Person person) {
        if (person == null) {
            return;
        }
        String name = person.getLastName();
        if (name == null || name.isEmpty()) {
            return;
        }
        if (name.length() > 10) {
            name = name.substring(0, 10);
        }
        name = name.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        if (!Objects.equals(name, person.getLastName())) {
            person.setLastName(name);
        }
    }

    private static class City {

        private String name;

        City(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }
    }

    private static class Person {

        private String firstName;
        private String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        String getLastName() {
            return lastName;
        }

        void setLastName(String lastName) {
            this.lastName = lastName;
        }

        String fullName() {
            return firstName + " " + lastName;
        }
    }
}
