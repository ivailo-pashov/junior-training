package com.epam.junx.streams.playground;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Playground {


    public static void main(String[] args) {
//        Stream.of(1, 3, 4, 6, 7, 11, 0, 2)
//                .filter(i -> i % 2 == 0)
//                .map(i -> i * 2)
//                .peek(i -> {
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        Thread.currentThread().interrupt();
//                    }
//                })
//                .sorted()
//                .forEach(System.out::println);


//        ThreadLocalRandom.current().ints()
//                .limit(1_000_000)
//                .sorted()
//                .forEach(System.out::println);

        System.out.println(
                Stream.of(1, 3, 4, 6, 7, 11, 0, 2)
                        .anyMatch(i -> i > 0)
        );

        System.out.println(
                Stream.of(1, 3, 4, 6, 7, 11, 0, 2)
                        .reduce("", (x, y) -> x + (x.isEmpty() ? "" : ", ") + y, (x, y) -> x + ", " + y)
        );


        System.out.println(
                Stream.of(1, 2, 3)
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 4), Arrays.asList(0))
                .flatMap(list -> ThreadLocalRandom.current().ints().limit(list.size()).boxed())
                .forEach(System.out::println);

        Optional.ofNullable("123").ifPresent(System.out::println);
        
        
        
        String textDocument = "This is a text. This is a very long text. More details to be included";
        List<String> mostCommonWords = Stream.of(textDocument.split("\\s+|[.]"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .limit(4)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(mostCommonWords);
        
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
                sum += Stream.of(1,2,3).mapToInt(Integer::intValue).sum();
        }
        for (int i = 0; i < 1_000_000; i++) {
            for (int j = 1; j <= 3; j++) {
                sum += j;
            }
        }

        sum = IntStream.range(0, 1_000_000)
                .map(i -> i+ 1)
                .map((i -> i + 2))
                .map((i -> i + 3))
                .sum();
        
        
    }
}
