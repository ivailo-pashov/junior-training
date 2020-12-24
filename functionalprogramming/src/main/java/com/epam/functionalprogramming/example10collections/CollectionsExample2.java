package com.epam.functionalprogramming.example10collections;

import java.util.HashMap;
import java.util.Map;

public class CollectionsExample2 {

    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    public static void main(String[] args) {

        //introduce caching with Map.computeIfAbsent

        System.out.println(fib(40));
    }

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return CACHE.computeIfAbsent(n - 1, CollectionsExample2::fib) +
            CACHE.computeIfAbsent(n - 2, CollectionsExample2::fib);
    }
}
