package com.epam.functionalprogramming.example6methodreference;

import java.util.function.Function;

public class MethodReferenceExample1 {

    public static void main(String[] args) {

        printGreetings(from -> greet(from));

        //static method reference

    }

    private static String greet(String from) {
        return "Greetings from " + from;
    }

    private static void printGreetings(Function<String, String> greetingsProvider) {
        System.out.println(greetingsProvider.apply("Jane"));
    }
}
