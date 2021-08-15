package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamArray {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,-6,8,5,-5, -2, 12, -8);
        List<Integer> rsl = list.stream().filter(l -> l > 0).collect(Collectors.toList());
        rsl.stream().forEach(System.out::println);
    }
}
