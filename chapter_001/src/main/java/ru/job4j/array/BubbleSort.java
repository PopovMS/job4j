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
        int temp, n = 1;
        for (int k = 0; k < array.length - 1; k++) {
            for (int i = 0; i < array.length - n; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            n++;
        }
        return array;
    }
}
