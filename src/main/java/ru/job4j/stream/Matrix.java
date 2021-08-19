package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> inList(int[][] input) {
        return Stream.of(input)
                .flatMapToInt(IntStream::of)
                .boxed()
                .collect(Collectors.toList());
    }
}
