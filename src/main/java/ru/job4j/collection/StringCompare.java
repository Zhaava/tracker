package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() <= right.length()) {
            for (int i = 0; i < left.length(); i++) {
                rsl +=  Character.compare(left.charAt(i), right.charAt(i));
            }
            if (rsl == 0 && (left.length() < right.length())) {
                rsl = -1;
            }
        } else {
            for (int i = 0; i < right.length(); i++) {
                rsl +=  Character.compare(left.charAt(i), right.charAt(i));
            }
            if (rsl == 0 && (right.length() < left.length())) {
                rsl = -1;
            }
        }
        return rsl;
    }
}
