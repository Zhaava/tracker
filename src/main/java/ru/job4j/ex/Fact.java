package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        System.out.println(Fact.calc(5));
        System.out.println(Fact.calc(-5));
    }

    public static int calc(int n) {
        int rsl = 1;
        if (n < 0) {
            throw new IllegalArgumentException("n must be more then 0.");
        }
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
