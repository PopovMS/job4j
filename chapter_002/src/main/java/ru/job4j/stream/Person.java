package ru.job4j.stream;

public class Person {
    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    static class Builder {
        private String name;
        private String surname;
        private int age;
        private int height;
        private int weight;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildHeight(int height) {
            this.height = height;
            return this;
        }

        Builder buildWeight(int weight) {
            this.weight = weight;
            return this;
        }

        Person build() {
            Person person = new Person();
            person.name = name;
            person.surname = surname;
            person.age = age;
            person.height = height;
            person.weight = weight;
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
