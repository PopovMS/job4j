package ru.job4j.loop;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    /**
     * Находит четные числа в диапазоне и складывает их
     * @param start задает начало диапазона
     * @param finish задает конец диапазона
     * @return возвращает сумму всех четных чисел из диапазона
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int count = start; count <= finish; count++) {
            if ((count % 2) == 0) {
                sum += count;
            }
        }
        return sum;
    }
}
