package ru.job4j.stream;

import java.util.Objects;

/**
 * Модель данных Student - содержит поля имени и количества баллов, геттер и сеттер к ним.
 * Переопределены hashCode  и equals
 * @author Popov Mikhail (m.popov83@gmail.com)
 */
public class Student implements Comparable<Student> {
    private int score;

    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }

    @Override
    public int compareTo(Student another) {
        return Integer.compare(score, another.score);
    }
}