package ru.job4j.array;

import java.util.Arrays;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    /**
     * перемещает дубликаты и уникальные значения массива
     * @param array принимает массив
     * @return возвращает массив
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}