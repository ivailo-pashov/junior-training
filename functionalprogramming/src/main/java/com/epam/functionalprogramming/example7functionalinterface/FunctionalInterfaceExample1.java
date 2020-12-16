package com.epam.functionalprogramming.example7functionalinterface;

public class FunctionalInterfaceExample1 {

    public static void main(String[] args) {
        printGreetings(prefix -> prefix + "From EPAM");
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
