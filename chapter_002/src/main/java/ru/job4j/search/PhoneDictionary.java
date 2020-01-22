package ru.job4j.search;

import java.util.ArrayList;

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
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (
                    person.getName().contains(key)
                 || person.getSurname().contains(key)
                 || person.getAddress().contains(key)
                 || person.getPhone().contains(key)
            ) {
             result.add(person);
            }
        }
        return result;
    }
}