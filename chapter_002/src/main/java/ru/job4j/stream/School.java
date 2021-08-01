package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс принимает список List и поведение через предикат. Формирует исходящий
 * список отфильтрованных елементов
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                        .filter(predict)
                        .collect(Collectors.toList());
    }
}
