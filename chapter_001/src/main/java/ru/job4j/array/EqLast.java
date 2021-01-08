package ru.job4j.array;

/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

/**
 * возвращает true или false в зависимости равны или не равны последние элементы массива
 */

public class EqLast {
    public static boolean check(int[] left, int[] right) {
        boolean result = false;
        if (left[left.length - 1] == right[right.length - 1]) {
            result = true;
        }
        return result;
    }
}