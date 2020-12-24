package com.epam.functionalprogramming.example3standardfunctionalinterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesExample1 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider

        UnaryOperator<String> provider = UnaryOperator.identity(); //same as x -> x
        printGreetings(provider);

    }

    private static void printGreetings(Function<String, String> provider) {
        System.out.println(provider.apply("Greetings "));
    }
}
