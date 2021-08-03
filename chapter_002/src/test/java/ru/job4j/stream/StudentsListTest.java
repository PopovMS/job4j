package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

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
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        StudentsList list = new StudentsList();
        Map<String, Student> rsl = list.toMap(students);
        Map<String, Student> expected = new HashMap<String, Student>();
        for (Student value : students) {
            expected.put(value.getSurname(), value);
        }
        assertThat(rsl, is(expected));
    }
}
