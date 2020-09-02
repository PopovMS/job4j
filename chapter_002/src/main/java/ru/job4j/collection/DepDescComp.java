package ru.job4j.collection;

import java.util.Comparator;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = o2.split("/")[0].compareTo(o1.split("/")[0]);
        if (result == 0) {
            result = o1.compareTo(o2);
        }
        return result;
    }
}