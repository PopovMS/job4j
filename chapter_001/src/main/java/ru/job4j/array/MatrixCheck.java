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
        for (int i = 0; i < data.length - 1; i++) {
            if ((data[0][0] != data[i + 1][i + 1]) || (data[0][data.length - 1] != data[i + 1][data.length - i - 2])) {
                result = false;
                break;
            }
        }
        return result;
    }
}