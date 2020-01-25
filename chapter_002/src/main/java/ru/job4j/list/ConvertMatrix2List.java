package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertMatrix2List {
    /**
     * создает одномерный массив List из матрицы
     * @param array - принимает матрицу
     * @return - возвращает List
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}