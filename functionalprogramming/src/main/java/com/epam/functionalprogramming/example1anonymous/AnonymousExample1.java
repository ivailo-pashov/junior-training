package com.epam.functionalprogramming.example1anonymous;

public class AnonymousExample1 {

    public static void main(String[] args) {

        int localVariable = 5;
        GreetingsProvider provider = new GreetingsProvider() {

            @Override
            public String greet(String from) {
                return from + localVariable;
            }
        };
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }

    private interface GreetingsProvider {

        String greet(String from);
    }
}
