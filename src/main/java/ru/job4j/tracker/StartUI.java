package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== Show existing Items ====");
        Item[] items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Rename item by id ====");
        int id = input.askInt("Enter id item to edit: ");
        String name = input.askStr("Enter new name to item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Operation succeed.");
        } else {
            System.out.println("Operation is incorrect.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item by id ====");
        int id = input.askInt("Enter id item to delete: ");
        if (tracker.delete(id)) {
            System.out.println("Operation succeed.");
        } else {
            System.out.println("Operation is incorrect.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ====");
        int id = input.askInt("Enter id to find item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name to find items: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Items not found");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                System.out.println("=== Closing program ====");
                run = false;
            } else {
                System.out.println("Invalid number!");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
