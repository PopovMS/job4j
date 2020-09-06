package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SearchAtt {
    /**
     * ищет во входящей коллекции по параметру size
     * @param list - входящая коллекция
     * @param size - параметр поиска
     * @return - возврат коллекции с найденными элементами
     */

    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return size;
            }
        };
        Predicate<Attachment> att = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                boolean result = false;
                if (attachment.getSize() > initValue.get()) {
                    result = true;
                }
                return result;
            }
        };
        return filter(list, att);
    }

    /**
     * поиск во входящей коллекции по имени
     * @param list - входящая коллекция
     * @param name - параметр поиска
     * @return - возврат коллекции с найденными элементами
     */

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Supplier<String> initValue = new Supplier<String>() {
            @Override
            public String get() {
                return name;
            }
        };
        Predicate<Attachment> att = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                boolean result = false;
                if (attachment.getName().contains(initValue.get())) {
                    result = true;
                }
                return result;
            }
        };
        return filter(list, att);
    }

    /**
     * Универсальный метод filter
     * @param list -входящая коллекция
     * @param attachment - объект с условиями поиска
     * @return - возврат коллекции с найденными элементами
     */
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> attachment) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (attachment.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}