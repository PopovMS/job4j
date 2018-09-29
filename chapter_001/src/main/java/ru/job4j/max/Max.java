package ru.job4j.max;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {

    /**
     * Сравнивает две переменные.
     *
     * @param first  Первая сравниваемая переменная.
     * @param second Вторая сравниваемая переменная.
     * @param third  Третья сравниваемая переменная.
     * @return возвращает большее число.
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        temp = this.max(temp, third);
        return temp;
    }

    public int max(int first, int second) {
        return first > second ? first : second;
    }
}