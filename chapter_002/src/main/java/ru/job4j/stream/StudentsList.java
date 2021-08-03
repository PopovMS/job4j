package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс создает карту с помощью Collectors.toMap из ArrayList
 * @author Popov Mikhail (m.popov83@gmail.com)
 */

public class StudentsList {
    public Map<String, Student> toMap(List<Student> list) {
        return list.stream()
                    .distinct()
                    .collect(Collectors.toMap(
                            name -> name.getSurname(),
                            student -> student,
                            (f, s) -> f.equals(s) ? f : s
                    ));
    }
}
