package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Petrov");
        student.setGroup(202);
        student.setDateOfAdmission(new Date(2000, 5, 6));

        System.out.println(student.getName() + System.lineSeparator() + "group: "
                + student.getGroup() + System.lineSeparator() + "year of admission: "
                + student.getDateOfAdmission().getYear() + System.lineSeparator() + "month of admission: "
                + student.getDateOfAdmission().getMonth());
    }
}
