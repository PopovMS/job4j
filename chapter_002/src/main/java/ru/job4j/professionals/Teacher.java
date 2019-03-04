package ru.job4j.professionals;

public class Teacher extends Professional {
    public Teacher(String name, String prof) {
        super(name, prof);
    }

    public Learn learn(Student student) {
        return new Learn();
    }
}