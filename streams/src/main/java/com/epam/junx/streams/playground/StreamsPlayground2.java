package com.epam.junx.streams.playground;

import java.util.Random;

public class StreamsPlayground2 {

    public static void main(String[] args) {

        new Random().ints()
            .limit(10)
            .forEach(System.out::println);
    }
}
