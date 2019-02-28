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
        for (int index = 0; index < array.length - index; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
