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
 * Тесты класса MatrixToList
 * @author Popov Mikhail (m.popov83@gmail.com)
 */
public class MatrixToListTest {
    @Test
    public void matrixToList() {
        Integer[][] matrix = {{1, 3, 4, 2}, {8, 6, 7, 5}};
        MatrixToList list = new MatrixToList();
        List<Integer> exp = List.of(1, 3, 4, 2, 8, 6, 7, 5);
        assertThat(list.tolist(matrix), is(exp));

    }
}
