package com.epam.junx.streams.playground;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamsPlayground4 {

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .skip(5)
            .limit(2)
            .filter(i -> {
                System.out.println("Filter " + i);
                return i % 2 == 0;
            })
            .map(i -> {
                System.out.println("Map " + i);
                return i * i;
            })
            .sorted()
            .peek(i -> System.out.println("After Sort " + i))
            .forEach(System.out::println);

        Stream.of(1, 2, 3, 1, 1, 4, 3, 5)
            .peek(i -> System.out.println("Before Distinct " + i))
            .distinct()
            .peek(i -> System.out.println("After Distinct " + i))
            .forEach(System.out::println);

        Stream.of(
            new Person("John", "Doe"),
            new Person("Mike", "Miller"),
            new Person("John", "Bar")
        )
            .peek(i -> System.out.println("Before Distinct " + i))
            .map(p -> new DistinctHelper(p, Collections.singletonList(Person::getFirstName)))
            .distinct()
            .map(DistinctHelper::getPerson)
            .peek(i -> System.out.println("After Distinct " + i))
            .forEach(System.out::println);
    }

    private static class DistinctHelper {

        private final Person person;
        private final List<Function<Person, ?>> properties;

        public DistinctHelper(Person person, List<Function<Person, ?>> properties) {
            this.person = person;
            this.properties = properties;
        }

        public Person getPerson() {
            return person;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            DistinctHelper that = (DistinctHelper) o;
            for (Function<Person, ?> prop : properties) {
                if (!Objects.equals(prop.apply(this.person), prop.apply(that.person))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(
                properties.stream()
                    .map(prop -> Objects.hashCode(prop.apply(person)))
                    .toArray()
            );
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

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Person person = (Person) o;
            return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        @Override
        public String toString() {
            return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
        }
    }
}
