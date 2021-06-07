package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Elements in array could not be found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] testArray = {"5", "7", "2", "4"};
        String key = "1";
        try {
            System.out.println(indexOf(testArray, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
