package com.epam.junx.streams.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPlayground3 {

    public static void main(String[] args) {

        Map<String, String> map = null;

        Collection<Integer> ints = Arrays.asList(1, 2, 3);
    }

    private static <T> List<T> join1(List<T> first, List<T> second) {
        return Stream.concat(first.stream(), second.stream())
            .map(i -> {
                //do blocking I/O operation
                return i;
            })
            .collect(Collectors.toList());
    }

    private static <T> List<T> join2(List<T> first, List<T> second) {
        List<T> result = new ArrayList<>(first.size() + second.size());
        result.addAll(first);
        result.addAll(second);
        return result;
    }
}
