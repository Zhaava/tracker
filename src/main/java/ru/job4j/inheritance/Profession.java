package ru.job4j.inheritance;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public Profession(String name, String surname, String education, int birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
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
        Profession man = new Builder("Petya", "Ivanov", "MISI", 1980);
        System.out.println(man.getName());

        Programmer man1 = new Programmer("Vasya", "Petrov", "MIPT", 1985, "JAVA");
        System.out.println(man1.getLanguage());

        Surgeon man3 = new Surgeon("Vasya", "Petrov", "Sechenov university",
                                    1985, "Botkinskaya hospital");
        System.out.println(man3.getWorkPlace());
    }
}
