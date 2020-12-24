package com.epam.functionalprogramming.example4capturing;

public class ScopeExample2 {

    public static void main(String[] args) {
        //refer to local variable in GreetingsProvider lambda

        int local = 5;
        GreetingsProvider provider2 = prefix -> local + "";

        //try updating local
        
        

    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
