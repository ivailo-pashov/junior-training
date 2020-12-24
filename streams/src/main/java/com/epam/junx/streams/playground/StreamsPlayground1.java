package com.epam.junx.streams.playground;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamsPlayground1 {

    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .filter(i -> {
                System.out.println("Filter " + i);
                return i % 2 == 0;
            })
            .map(i -> {
                System.out.println("Map " + i);
                return i * i;
            })
            .sorted(Comparator.reverseOrder())
            .peek(i -> System.out.println("After Sort " + i))
            .forEach(System.out::println);
    }
}
