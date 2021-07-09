package ru.job4j.collection;


import java.util.HashSet;
import java.util.Set;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        Set<String> check = new HashSet<>();
        for (String element : origin) {
            check.add(element);
        }
        for (String element : text) {
            if (!(rsl = check.contains(element))) {
                break;
            }
        }
        return rsl;
    }
}
