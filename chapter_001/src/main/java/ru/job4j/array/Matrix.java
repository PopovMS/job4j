package ru.job4j.array;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    /**
     * заполняет двухмерный массив перемноженными числами
     * @param size принимает размер матрицы
     * @return возвращает массив
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < table.length; row++) {
            for (int cell = 0; cell < table[row].length; cell++) {
                table[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return table;
    }



}
