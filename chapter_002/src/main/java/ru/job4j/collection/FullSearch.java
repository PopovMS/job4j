package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FullSearch {
    /**
     * извлекает из списка задач номер
     * @param list - список задач
     * @return - возвращает список уникальных номеров задач
     */
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task task : list) {
            numbers.add(task.getNumber());
        }
        return numbers;
    }
}