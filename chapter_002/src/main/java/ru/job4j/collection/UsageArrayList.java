package ru.job4j.collection;

import java.util.ArrayList;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UsageArrayList {
    /**
     * запись в коллекцию строковых значений и вывод в консоль
     * @param ags
     */
    public static void main(String[] ags) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
