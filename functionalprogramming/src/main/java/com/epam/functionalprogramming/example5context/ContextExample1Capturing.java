package com.epam.functionalprogramming.example5context;

import java.util.function.IntUnaryOperator;

public class ContextExample1Capturing {

    public static void main(String[] args) {

    }

    private static IntUnaryOperator incrementBy(int inc) {
        return x -> x + inc;
    }
}
