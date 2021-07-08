package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }

    public static void main(String[] args) {
        SingleTracker test = SingleTracker.getInstance();
        test.add(new Item("Ivan"));
        test.add(new Item("Petr"));
        System.out.println(test.findByName("Ivan"));
        System.out.println(test.findByName("Petr"));
    }
}
