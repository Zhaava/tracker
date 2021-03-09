package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String workPlace;

    public Surgeon(String name, String surname, String education, int birthday, String workPlace) {
        super(name, surname, education, birthday);
        this.workPlace = workPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public  void cutAppendix() {}
}
