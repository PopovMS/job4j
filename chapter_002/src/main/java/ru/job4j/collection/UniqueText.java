package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UniqueText {
    /**
     * сравнивает две строки текста
     * @param originText оригинальный текс
     * @param duplicateText сравниваемый текс
     * @return возвращает true, если текс идентичен.
     */
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        check.addAll(Arrays.asList(origin));
        for (String value : text) {
            if (!check.contains(value)) {
                rsl = false;
                break;
            }
        }
        // for-each text -> hashSet.contains
        return rsl;
    }
}