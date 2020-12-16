package com.epam.functionalprogramming.example2lambda;

public class LambdaExample1 {

    public static void main(String[] args) {

        //simplest form

        //with braces

        //assign to variable

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }

    private interface GreetingsProvider {

        String greet(String from);
    }
}
