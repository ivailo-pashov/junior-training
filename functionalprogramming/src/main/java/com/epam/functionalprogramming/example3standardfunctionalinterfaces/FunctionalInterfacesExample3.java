package com.epam.functionalprogramming.example3standardfunctionalinterfaces;

import java.util.function.Supplier;

public class FunctionalInterfacesExample3 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider

        //refer printGreetings as Consumer

        Supplier<String> provider;
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet());
    }

    private interface GreetingsProvider {

        String greet();
    }
}
