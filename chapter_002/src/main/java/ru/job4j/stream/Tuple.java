package ru.job4j.stream;

import java.util.Objects;

/**
 * Класс описывсет модель данных Tuple.
 * Содержит результаты: имя и баллы.
 * Этот класс используется как для учеников, так и для предметов.
 */
public class Tuple implements Comparable<Tuple> {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }


    @Override
    public int compareTo(Tuple another) {
        return Double.compare(score, another.score);
    }
}