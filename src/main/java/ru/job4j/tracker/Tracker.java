package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
//    private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
//    private int size = 0;

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
//            items[index] = item;
            items.add(index, item);
            items.remove(index + 1);

        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
//        items[size++] = item;
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }

    public ArrayList<Item> findByName(String key) {
//        Item[] rsl = new Item[size];
        ArrayList<Item> rsl = new ArrayList<>();
//        int len = 0;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getName().equals(key)) {
//                rsl[len] = items[index];
//                len++;
//            }
//        }
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
//        if (rsl) {
//            System.arraycopy(items, index + 1, items, index, size - index - 1);
//            items[size - 1] = null;
//            size--;
//        }
        if (rsl) {
            items.remove(id - 1);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getId() == id) {
//                rsl = index;
//                break;
//            }
//        }
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
