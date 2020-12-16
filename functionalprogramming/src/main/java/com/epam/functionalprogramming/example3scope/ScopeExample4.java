package com.epam.functionalprogramming.example3scope;

public class ScopeExample4 {

    public static void main(String[] args) {
        //refer  to from() method in GreetingsProvider lambda
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private static String from() {
        return "From: ";
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
