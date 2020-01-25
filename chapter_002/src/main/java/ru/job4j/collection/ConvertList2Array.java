package ru.job4j.collection;

import java.util.List;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * создает двумерный массив из одномерного
     * @param list - принимает одномерный массив
     * @param cells - задает количество ячеек в строке двумерного массива
     * @return - возврат двумерного массива.
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell == cells) {
                cell = 0;
                row++;
            }
            array[row][cell] = num;
            cell++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}