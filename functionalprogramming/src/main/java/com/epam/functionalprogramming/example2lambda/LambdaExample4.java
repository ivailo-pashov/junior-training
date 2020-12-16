package com.epam.functionalprogramming.example2lambda;

public class LambdaExample4 {

    public static void main(String[] args) {

        //specify lambda interface

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }

    private static void printGreetings(GreetingsProvider2 provider) {
        System.out.println(provider.greet("Jane"));
    }

    private interface GreetingsProvider {

        String greet(String from);
    }

    private interface GreetingsProvider2 {

        String greet(String from);
    }
}
