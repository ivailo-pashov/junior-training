package com.epam.functionalprogramming.example2lambda;

public class LambdaExample5 {

    public static void main(String[] args) {

        //specify parameter type
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }

    private static void printGreetings(GreetingsProvider2 provider) {
        System.out.println(provider.greet(0));
    }

    private interface GreetingsProvider {

        String greet(String from);
    }

    private interface GreetingsProvider2 {

        String greet(int from);
    }
}
