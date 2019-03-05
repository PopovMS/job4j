package ru.job4j.professionals;

public class Engineer extends Professional {
    public Engineer (String name, String prof) {
        super(name, prof);
    }
    public Build bilding(House house) {
        return new Build();
    }
}