package ru.job4j.sort;

import java.util.Arrays;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Machine {
    /**
     * Массив для хранения монет
     */
    private final int[] coins = {10, 5, 2, 1};

    /**
     * возвращает сдачу ввиде набора монет
     * @param money - количество полученных денег
     * @param price - стоимость кофе
     * @return - массив из монет со сдачей
     */
    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = -1;
        int diff = money - price;
        for (int coin : coins) {
            while (diff >= coin) {
                diff -= coin;
                rsl[++size] = coin;
            }
            if (diff == 0) {
                break;
            }
        }
        return Arrays.copyOf(rsl, size + 1);
    }
}