package ru.job4j.array;
/*
  @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

/**
 * Проверяет, что массив word имеет последние элементы одинаковые с post
 */
public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        for (int index = 0; index < post.length; index++) {
            if (word[word.length - 1 - index] != post[post.length - 1 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
