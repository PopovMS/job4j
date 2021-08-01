package ru.job4j.stream;

/**
 * Класс описывает модель данных пользователя Profile
 */
public class Profile {
    private Address address;
    private String name;

    public Profile(Address address, String name) {
        this.address = address;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
