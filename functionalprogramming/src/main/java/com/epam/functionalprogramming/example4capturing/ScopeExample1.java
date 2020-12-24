package com.epam.functionalprogramming.example4capturing;

public class ScopeExample1 {

    public static void main(String[] args) {
        
        GreetingsProvider provider1 = new GreetingsProvider() {

            @Override
            public String greet(String prefix) {
                return from() + this;
            }
        };
        
        printGreetings(provider1);

        GreetingsProvider provider2 = prefix -> from();

        //use from() method in anonymous class and append this

        //use from() method in lambda function and append this
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private static String from() {
        return "From: ";
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
