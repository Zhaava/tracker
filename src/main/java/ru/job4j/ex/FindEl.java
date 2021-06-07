package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                throw new ElementNotFoundException("Elements in array could not be null");
            }
            if (Integer.parseInt(value[i]) == Integer.parseInt(key)) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] testArray = {"5", "7", null, "12"};
        String key = "12";
        try {
            System.out.println(indexOf(testArray, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }
}
