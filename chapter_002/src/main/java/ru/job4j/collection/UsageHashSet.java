package ru.job4j.collection;

import java.util.HashSet;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UsageHashSet {
    /**
     * Добавляет в коллекцию HashSet значения и выводит в консоль
     * @param args
     */
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String name : autos) {
            System.out.println(name);
        }
    }
}