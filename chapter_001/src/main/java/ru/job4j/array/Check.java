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
        boolean result = true;
        for (boolean i : data){
            if (data[0] != i){
                result = false;
                break;
            }
        }
        return result;
    }
}