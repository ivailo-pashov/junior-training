package com.epam.functionalprogramming.example1anonymous;

public class AnonymousExample2 {

    public static void main(String[] args) {
        int localVariable = 5;
        GreetingsProvider provider = new GreetingsProvider() {
            
            private int field = localVariable;

            @Override
            public String greet(String from, String to) {
                field = 4;
                return field + "";
            }

            @Override
            public String greet(String from) {
                return null;
            }
        };
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Jane", "Mike"));
    }

    private interface GreetingsProvider {

        String greet(String from, String to);
        
        String greet(String from);
    }
}
