package com.epam.functionalprogramming.example4standardfunctionalinterfaces;

public class FunctionalInterfacesExample1 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
