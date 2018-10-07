package ru.job4j.array;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {
    /**
     * возводит каждое число массива в квадрат
     * @param bound параметр задает длину массива
     * @return возвращает массив с результатами
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i ++){
            rst[i] = (i + 1)*(i + 1);
        }
        return rst;
    }
}