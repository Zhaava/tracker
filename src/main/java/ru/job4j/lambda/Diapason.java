package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    public static List<Double> diapasonCalc(int start, int end,
                                            Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        while (start < end) {
            rsl.add(func.apply(Double.valueOf(start)));
            start++;
        }
        return rsl;
    }
}
