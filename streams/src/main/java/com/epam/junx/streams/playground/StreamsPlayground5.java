package com.epam.junx.streams.playground;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsPlayground5 {

    public static void main(String[] args) {

        System.out.println(
            Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
            )
                .flatMap(list -> list.stream().filter(el -> el % 2 == 0 && list.size() > 2))
                .findAny()
        );

        System.out.println(
            Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
            )
                .flatMap(list -> list.stream().filter(el -> el % 2 == 0 && list.size() > 2))
                .count()
        );
    }
}
