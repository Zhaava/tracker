package ru.job4j.ooa;

public final class Airbus {
    private final static int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public final void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public final void printCountEngine() {
        int countEngineLocal = 0;
        if (name.equals("A380")) {
            countEngineLocal = 4;
        } else if (name.equals("A400")) {
            countEngineLocal = 6;
        } else {
            countEngineLocal = COUNT_ENGINE;
        }
        System.out.println("Количество двигателей равно: " + countEngineLocal);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}

