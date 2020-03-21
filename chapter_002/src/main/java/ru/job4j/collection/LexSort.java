package ru.job4j.collection;

import java.util.Comparator;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class LexSort implements Comparator<String> {
    /**
     * преобразует число из начала строки в int и сравнивает
     * @param left - входящая строка
     * @param right - входящая строка
     * @return - результат сравнения
     */

    @Override
    public int compare(String left, String right) {
        Integer leftInt = Integer.parseInt(left.split("\\.", 2)[0]);
        Integer rightInt = Integer.parseInt(right.split("\\.", 2)[0]);
        return leftInt.compareTo(rightInt);
    }
}