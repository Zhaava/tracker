package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdItemUp implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(first.getId(), second.getId());
    }
}
