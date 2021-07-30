package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int rsl = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            rsl = Character.compare(s2.charAt(i), s1.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(s1.length(), s2.length());
        }
        return rsl;
    }
}
