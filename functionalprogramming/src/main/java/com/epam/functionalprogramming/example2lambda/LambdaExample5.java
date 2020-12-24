package com.epam.functionalprogramming.example2lambda;

public class LambdaExample5 {

    public static void main(String[] args) {

        GreetingsProvider provider = x -> x;
        //specify parameter type
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }

    private static void printGreetings(GreetingsProvider2 provider) {
        System.out.println(provider.greet(0));
    }

    @FunctionalInterface
    private interface GreetingsProvider {

        String greet(String from);
        
        default void doNothing() {
            
        }
    }

    private interface GreetingsProvider2 {

        String greet(int from);
    }
}
