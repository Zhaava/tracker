package ru.job4j.encapsulation;

public class Config {
    private String name;
    private int position;
    private String[] properties;

    public Config(String name) {
        this.name = name;
    }

    void print() {
        System.out.println(position);
    }

    public String getProperty(String key) {
        return search(key);
    }

    private String search(String key) {
        for (String step : properties) {
            if (!step.equals(key)) {
                return "Incorrect key";
            } else {
                return key;
            }
        }
        return key;
    }
}
