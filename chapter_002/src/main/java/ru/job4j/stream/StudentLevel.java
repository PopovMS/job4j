package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс принимает список студентов и созает поток с фильтацией и сортировкой по полю bound
 * @author Popov Mikhail (m.popov83@gmail.com)
 */
public class StudentLevel {
    /**
     *
     * @param students Входящий список моделей данных Student
     * @param bound входящее число, проходное значение
     * @return возвращает отфильтрованный и сортированный список
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
