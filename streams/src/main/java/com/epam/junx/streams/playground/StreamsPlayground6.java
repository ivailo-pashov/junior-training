package com.epam.junx.streams.playground;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPlayground6 {

    public static void main(String[] args) {

        System.out.println(
            Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
            )
                .flatMap(list -> list.stream().filter(el -> el % 2 == 0 && list.size() > 2))
                .collect(Collectors.toList())
        );

        System.out.println(
            Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
            )
                .flatMap(list -> list.stream().filter(el -> el % 2 == 0 && list.size() > 2))
                .collect(Collectors.toMap(i -> i, i -> i))
        );


        System.out.println(
            Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
            )
                
                .flatMap(list -> list.stream().filter(el -> el % 2 == 0 && list.size() > 2))
                .map(i -> {
                    try {
                        return transform(i);
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .collect(Collectors.groupingBy(i -> i % 4,
                    Collectors.summingInt(Integer::intValue)))
        );
    }
    
    static Integer transform(Integer other) throws Exception {
        return other;
    }
}
