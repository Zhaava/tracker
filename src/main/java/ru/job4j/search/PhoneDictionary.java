package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combineAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combineName = p -> p.getName().contains(key);
        Predicate<Person> combineSurname = p -> p.getSurname().contains(key);
        Predicate<Person> combinePhone = p -> p.getPhone().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combineAddress.test(person) || combineName.test(person)
            || combineSurname.test(person)  || combinePhone.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
