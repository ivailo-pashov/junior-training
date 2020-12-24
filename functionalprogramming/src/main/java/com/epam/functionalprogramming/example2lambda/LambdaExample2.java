package com.epam.functionalprogramming.example2lambda;

public class LambdaExample2 {

    public static void main(String[] args) {
        //multiple arguments

        GreetingsProvider provider = (from, to) -> "Greetings from " + from + " to " + to;

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane", "Mike"));
    }

    private interface GreetingsProvider {

        String greet(String from, String to);
    }
}
