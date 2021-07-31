package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] arrO1 = o1.split("/");
        String[] arrO2 = o2.split("/");
        int rsl = arrO2[0].compareTo(arrO1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
