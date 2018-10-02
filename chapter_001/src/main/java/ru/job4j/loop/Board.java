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
        for (int i = 1; i <= height; i++) {
            for (int k = 1; k <= width; k++) {
                if (((i + k) % 2) == 0) {
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