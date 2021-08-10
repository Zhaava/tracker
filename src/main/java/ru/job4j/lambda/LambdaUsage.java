package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] strings = {
                "ab",
                "b",
                "abcde",
                "abcdef"
        };
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left.length() + ":" + right.length());
            return Integer.compare(right.length(), left.length());
        };
        Arrays.sort(strings, comparator);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
