package com.epam.functionalprogramming.example1anonymous;

public class AnonymousExample2 {

    public static void main(String[] args) {

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane", "Mike"));
    }

    private interface GreetingsProvider {

        String greet(String from, String to);
    }
}
