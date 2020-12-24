package com.epam.functionalprogramming.example2lambda;

public class LambdaExample1 {

    public static void main(String[] args) {

        GreetingsProvider provider = x -> "Greetings from " + x;
        printGreetings(x -> "Greetings from " + x);

        provider = (x) -> "Greetings from " + x;

        doSthm("x" + 5);
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane"));
    }
    
    static void doSthm(String param) {
        
    }

    private interface GreetingsProvider {

        String greet(String from);
    }
}
