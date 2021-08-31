package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам
 */

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл
     * @param stream входной поток моделей данных учеников
     * @return возвращает средний балл
     */

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D);
    }

    /**
     * вычисляет средний балл ученика по его предметам.
     * @param stream входной поток моделей данных учеников
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                                            pupil.getSubjects().stream()
                                                                .mapToDouble(Subject::getScore)
                                                                .average()
                                                                .orElse(0D)))
                        .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream входной поток моделей данных учеников
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                        .collect(Collectors.groupingBy(Subject::getName,
                                 Collectors.averagingDouble(Subject::getScore)))
                        .entrySet().stream()
                                    .map(vol -> new Tuple(vol.getKey(), vol.getValue()))
                                    .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика. Лучшим считается ученик с наибольшим баллом по всем предметам
     * @param stream входной поток моделей данных учеников
     * @return возвращает модель данных Tuple
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                                            pupil.getSubjects().stream()
                                                                .mapToDouble(Subject::getScore)
                                                                .sum()))
                    .max(Tuple::compareTo)
                    .get();
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream входной поток моделей данных учеников
     * @return возвращает модель данных Tuple
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                        .collect(Collectors.groupingBy(Subject::getName,
                                    Collectors.summingDouble(Subject::getScore)))
                        .entrySet().stream()
                        .map(vol -> new Tuple(vol.getKey(), vol.getValue()))
                        .max(Tuple::compareTo)
                        .get();
    }
}