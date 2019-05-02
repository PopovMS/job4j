package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] value;
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    public String ask(String question) {
        return value[position++];
    }
}
