package ru.job4j.array;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    /**
     * проверяет одинаковы ли все значения
     * @param data принимает массив
     * @return возвращает результат
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        int t = 0;
        for (boolean i : data){
            if (i){
                t = t + 1;
            }
        }
        if (t == data.length || t == 0){
            result = true;
        }
        return result;
    }
}