package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item1 = new Item(1, "Petrov");
        Item item2 = new Item(2, "Ivanov");
        Item item3 = new Item(3, "Sidorov");
        Item item4 = new Item(4, "Egorov");
        Item item5 = new Item(5, "Sidorov");

        Tracker tracker = new Tracker();

        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.add(item5);
        tracker.delete(2);
        tracker.delete(4);

        for (Item i : tracker.findAll())
            System.out.println(i);
    }
}
