package ru.job4j.loop;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * рисует шахматную доску из символов X и пробелов
     * @param width - передает ширину поля
     * @param height - передает высоту поля
     * @return возвращает последовательность пробелов и символов X
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int row = 1; row <= height; row++) {
            for (int cell = 1; cell <= width; cell++) {
                if (((row + cell) % 2) == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}