package com.epam.functionalprogramming.example3scope;

public class ScopeExample1 {

    public static void main(String[] args) {

        //use from() method in anonymous class and append this

        //use from() method in lambda function and append this
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
