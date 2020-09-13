package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Возвращает список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = person -> person.getName().contains(key);
        Predicate<Person> checkSurname = person -> person.getSurname().contains(key);
        Predicate<Person> checkAddress = person -> person.getAddress().contains(key);
        Predicate<Person> checkPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = checkName.or(checkSurname.or(checkAddress.or(checkPhone)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
             result.add(person);
            }
        }
        return result;
    }
}