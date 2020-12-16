package com.epam.functionalprogramming.example10collections;

public class CollectionsExample2 {

    public static void main(String[] args) {

        //introduce caching with Map.computeIfAbsent

        System.out.println(fib(60));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
