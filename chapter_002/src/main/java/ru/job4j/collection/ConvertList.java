package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertList {
    /**
     * создает список чисел из списка целочисленных массивов
     * @param list - принимает список целочисленных массивов
     * @return - возвращает список
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }
}