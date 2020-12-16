package com.epam.functionalprogramming.example3scope;

public class ScopeExample3 {

    private int field = 5;

    //declare GreetingsProvider field and refer to "field" in the provider

    public static void main(String[] args) {
        //create ScopeExample3 instance and printGreetings

        //update "field" to 6 and printGreetings
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
