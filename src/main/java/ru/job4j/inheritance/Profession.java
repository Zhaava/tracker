package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Profession() {
        this.name = this.getClass().getName();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public int getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        Profession man = new Builder();
        System.out.println(man.getName());

        Profession man1 = new Programmer();
        System.out.println(man1.getName());
    }
}

