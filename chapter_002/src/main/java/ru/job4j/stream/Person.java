package ru.job4j.stream;

public class Person {
    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        Builder buildName(String name) {
            person.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            person.surname = surname;
            return this;
        }

        Builder buildAge(int age) {
            person.age = age;
            return this;
        }

        Builder buildHeight(int height) {
            person.height = height;
            return this;
        }

        Builder buildWeight(int weight) {
            person.weight = weight;
            return this;
        }

        Person build() {
            return person;
        }
    }


    public static void main(String[] args) {
        Person person = new Builder().buildName("Вася")
                                    .buildSurname("Пупкин")
                                    .buildAge(20)
                                    .buildHeight(180)
                                    .buildWeight(100)
                                    .build();
        System.out.println("Имя: " + person.name
                            + ", Фамилия: " + person.surname
                            + ", Возраст: " + person.age
                            + ", Рост: " + person.height
                            + ", Вес: " + person.weight);
    }
}
