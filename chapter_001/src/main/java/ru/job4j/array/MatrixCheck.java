package ru.job4j.array;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    /**
     * проверяет на однородность диагонали массива
     * @param data принимает двумерный массив
     * @return результат
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if ((data[0][0] != data[index + 1][index + 1]) || (data[0][data.length - 1] != data[index + 1][data.length - index - 2])) {
                result = false;
                break;
            }
        }
        return result;
    }
}