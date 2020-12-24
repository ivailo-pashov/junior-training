package com.epam.functionalprogramming.example3standardfunctionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class FunctionalInterfacesExample2 {

    public static void main(String[] args) {

        //get rid of GreetingsProvider
        BinaryOperator<String> provider = (x, y) -> x + y;
     }

    private static void printGreetings(BinaryOperator<String> provider) {
        System.out.println(provider.apply("Jane", "Mike"));
    }

}
