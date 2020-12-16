package com.epam.functionalprogramming.example4standardfunctionalinterfaces;

public class FunctionalInterfacesExample3 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider

        //refer printGreetings as Consumer
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet());
    }

    private interface GreetingsProvider {

        String greet();
    }
}
