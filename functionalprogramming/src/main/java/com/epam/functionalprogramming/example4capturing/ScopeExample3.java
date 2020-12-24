package com.epam.functionalprogramming.example4capturing;

public class ScopeExample3 {

    private int field = 5;

    //declare GreetingsProvider field and refer to "field" in the provider

    public static void main(String[] args) {
        //create ScopeExample3 instance and printGreetings

        ScopeExample3 example = new ScopeExample3();
        example.print();
        
        example.field = 6;
        example.print();

        //update "field" to 6 and printGreetings
    }

    private static void printGreetings(GreetingsProvider provider) {
        System.out.println(provider.greet("Greetings "));
    }

    void print() {
        GreetingsProvider provider = x -> x + this.field;
        printGreetings(provider);
    }
    
    private interface GreetingsProvider {

        String greet(String prefix);
    }
}
