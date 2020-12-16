package com.epam.functionalprogramming.example3scope;

public class ScopeExample2 {

    public static void main(String[] args) {
        //refer to local variable in GreetingsProvider lambda

        int local = 5;
        //refer to local variable in GreetingsProvider lambda

        //try updating local

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
