package com.epam.functionalprogramming.example6methodreference;

public class MethodReferenceExample3 {

    public static void main(String[] args) {
        Person person = new Person("ivan", "IVANoV");

        updateFirstName(person);
        updateLastName(person);
        System.out.println(person.fullName());
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
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        person.setFirstName(name);
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
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        person.setLastName(name);
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
