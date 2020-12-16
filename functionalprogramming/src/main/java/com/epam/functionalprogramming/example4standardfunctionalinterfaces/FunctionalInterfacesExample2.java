package com.epam.functionalprogramming.example4standardfunctionalinterfaces;

public class FunctionalInterfacesExample2 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane", "Mike"));
    }

    private interface GreetingsProvider {

        String greet(String from, String to);
    }
}
