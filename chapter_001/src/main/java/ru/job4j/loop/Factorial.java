package ru.job4j.loop;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    /**
     * Вычисляет факториал значения аргумента n
     * @param n входной аргумент
     * @return возвращает вычисленный факториал
     */
    public int calc(int n) {
        int result = 1;
        for (int count = 1; count <= n; count++) {
            result *= count;
        }
        return result;
    }
}
