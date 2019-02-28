package ru.job4j.array;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {
    /**
     * сортирует массив чисел
     * @param array массив
     * @return возрвращает отсортированный массив
     */
    public int[] sort(int[] array) {
        int temp, count = 1;
        for (int out = 0; out < array.length - 1; out++) {
            for (int index = 0; index < array.length - count; index++) {
                if (array[index] > array[index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
            count++;
        }
        return array;
    }
}
