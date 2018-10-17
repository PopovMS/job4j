package ru.job4j.array;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     * Переворачивает массив зеркально
     * @param array принимает целочисленный массив
     * @return возвращает перевернутый массив
     */
    public int[] turn(int[] array) {
        for (int i = 0; i < array.length - i; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
