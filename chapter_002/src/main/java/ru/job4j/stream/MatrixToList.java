package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс принимает двумерный массив
 * и формирует из него список чисел с помошью Stream API
 */
public class MatrixToList {
    public List<Integer> tolist(Integer[][] matrix) {
       return Stream.of(matrix)
                    .flatMap(Arrays::stream)
                                        .collect(Collectors.toList());
    }
}
