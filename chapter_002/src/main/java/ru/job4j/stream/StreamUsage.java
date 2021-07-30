package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс формирует ArrayList и получает из него фильтрованный поток
 * с использованием Stream API
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 *  * @version $Id$
 *  * @since 0.1
 */
public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-50);
        numbers.add(100);
        numbers.add(150);

        List<Integer> positive = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}