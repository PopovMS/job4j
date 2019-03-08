package ru.job4j.array;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayMerge {
    /**
     * слияние двух упорядоченных массивов в один упорядоченный
     * элементы первого массива сравниваются со вторым и меньшее значение записывается в третий.
     * при завершении элементов одного из массивов, элементы из длинного массива дописываются в конец третьего
     */
    public int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int fcount = 0, scount = 0, rcount = 0;
        while (fcount < first.length | scount < second.length) {
            if (first[fcount] < second[scount]) {
                result[rcount] = first[fcount];
                rcount++;
                fcount++;
            } else {
                result[rcount] = second[scount];
                rcount++;
                scount++;
            }
            if (fcount == first.length) {
                while (scount < second.length) {
                    result[rcount] = second[scount];
                    rcount++;
                    scount++;
                }
            }
            if (scount == second.length) {
                while (fcount < first.length) {
                    result[rcount] = first[fcount];
                    rcount++;
                    fcount++;
                }
            }
        }
        return result;
    }
}