package com.epam.functionalprogramming.example5context;

import java.util.function.IntUnaryOperator;

public class ContextExample1Capturing {

    public static void main(String[] args) {
        System.out.println(incrementBy(4).applyAsInt(4));
        System.out.println(incrementBy(2).applyAsInt(4));
    }

    private static IntUnaryOperator incrementBy(int inc) {
        return x -> x + inc;
    }
}
