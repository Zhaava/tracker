package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public List<Person> find(String key) {
        Predicate<Person> combineAddress = p -> p.getAddress().contains(key);
        Predicate<Person> combineName = p -> p.getName().contains(key);
        Predicate<Person> combineSurname = p -> p.getSurname().contains(key);
        Predicate<Person> combinePhone = p -> p.getPhone().contains(key);
        Predicate<Person> combineAll = combineAddress.or(combineName).or(combinePhone).or(combineSurname);
        List<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combineAll.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
