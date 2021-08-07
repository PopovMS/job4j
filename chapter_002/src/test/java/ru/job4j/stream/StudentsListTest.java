package ru.job4j.stream;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты класса StudentsList
 * @author Popov Mikhail (m.popov83@gmail.com)
 */


public class StudentsListTest {
    @Test
    public void listToMap() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname1"),
                new Student(50, "Surname5")
        );
        StudentsList list = new StudentsList();
        Map<String, Student> rsl = list.toMap(students);
        Map<String, Student> expected = new HashMap<>();
        for (Student value : students) {
            expected.put(value.getSurname(), value);
        }
        assertThat(rsl, is(expected));
    }
}
