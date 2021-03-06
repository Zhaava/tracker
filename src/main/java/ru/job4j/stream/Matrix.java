package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public List<Integer> inList(Integer[][] input) {
        return Stream.of(input)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
