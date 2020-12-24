package com.epam.functionalprogramming.example6methodreference;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MethodReferenceExample4Constructor {

    private static final Map<Type, BiFunction<String, String, Person>> constructors =
        new HashMap<Type, BiFunction<String, String, Person>>() {{
            put(Type.EMPLOYEE, Employee::new);
            put(Type.STUDENT, Student::new);
        }};

    public static void main(String[] args) {
        //use method references to refer to constructor
    }

    private static Person create(String firstName, String lastName, Type type) {
        return constructors.get(type).apply(firstName, lastName);
        //        switch (type) {
        //            case EMPLOYEE:
        //                return new Employee(firstName, lastName);
        //            case STUDENT:
        //                return new Student(firstName, lastName);
        //            default:
        //                throw new IllegalArgumentException();
        //        }
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
