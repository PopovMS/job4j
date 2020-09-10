package ru.job4j.lambda;

import java.util.*;
import java.util.function.Function;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Diap {
    /**
     * Вычисляет входящую функцию
     * @param start - начало диапазона чисел
     * @param end - конец диапазона чисел
     * @param func - входящаа формула
     * @return - возвращает массив вычесленных значений
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index < end; index++) {
            double var = (double) index;
            result.add(func.apply(var));
        }
        return result;
    }
}
