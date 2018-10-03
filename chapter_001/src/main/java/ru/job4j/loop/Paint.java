package ru.job4j.loop;
import java.util.function.BiPredicate;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * рисует пирамиду из пробелов и знаков ^
     * @param height высота пирамиды
     * @return возвращает результат
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * рисует пирамиду из пробелов и знаков ^
     * @param height высота пирамиды
     * @return возвращает результат
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * рисует пирамиду из пробелов и знаков ^
     * @param height высота пирамиды
     * @return возвращает результат
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * метод loopBy
     * @param height высота
     * @param weight длина
     * @param predict условие проставления галки
     * @return возрвращает результат
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}

