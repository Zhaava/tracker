package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book electronics = new Book("Electronics", 400);
        Book pushkin = new Book("Pushkin", 200);
        Book cleanCode = new Book("Clean code", 600);
        Book physics = new Book("Physics", 500);


        Book[] books = new Book[4];
        books[0] = electronics;
        books[1] = pushkin;
        books[2] = cleanCode;
        books[3] = physics;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ",amount of pages: " + book.getAmountOfPages());
        }

        System.out.println();

        books[0] = physics;
        books[3] = electronics;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getName() + ",amount of pages: " + book.getAmountOfPages());
        }

        System.out.println();

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + ",amount of pages: " + book.getAmountOfPages());
            }
        }
    }
}
