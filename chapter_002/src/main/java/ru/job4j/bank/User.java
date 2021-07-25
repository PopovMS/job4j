package ru.job4j.bank;

import java.util.Objects;
/**
 * Клас описывает модель данных пользователя системы банковских переводов
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class User {
    /**
     * Содержит 2 поля: паспортные данные и имя пользовалея
      */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * геттер дял получения паспортных данных
     * @return возвращает переменную паспортных данных
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для изменения переменной паспортных данных
     * @param passport принимает переменную паспортных данных
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для получения имени пользователя
     * @return возвращает переменную имени
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для изменения имени пользователя
     * @param username принимате переменную имени
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    /**
     * Переопределение метода сравнения для модели данных User для сравнения паспортных данных
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    /**
     * Переопределение HashCode для модели данных User.
     */
    public int hashCode() {
        return Objects.hash(passport);
    }
}