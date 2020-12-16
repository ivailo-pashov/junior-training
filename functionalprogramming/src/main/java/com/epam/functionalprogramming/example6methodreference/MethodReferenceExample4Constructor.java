package com.epam.functionalprogramming.example6methodreference;

public class MethodReferenceExample4Constructor {

    public static void main(String[] args) {

    }

    private static Person create(String firstName, String lastName, Type type) {
        switch (type) {
            case EMPLOYEE:
                return new Employee(firstName, lastName);
            case STUDENT:
                return new Student(firstName, lastName);
            default:
                throw new IllegalArgumentException();
        }
    }

    private enum Type {
        EMPLOYEE,
        STUDENT
    }

    private static class Employee extends Person {

        Employee(String firstName, String lastName) {
            super(firstName, lastName);
        }
    }

    private static class Student extends Person {

        Student(String firstName, String lastName) {
            super(firstName, lastName);
        }
    }

    private abstract static class Person {

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
