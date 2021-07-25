package ru.job4j.bank;

import java.util.Objects;
/**
 * Класс описывает модель данных банковского счета системы банковских переводов
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Account {
    /**
     * Содержит поля: рекизиты счета и баланс по счету
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер для возврата реквизитов
     * @return возвращает переменную реквизита счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер для изменения реквизитов
     * @param requisite принимает переменную реквизита счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер для получения баланса
     * @return возвращает переменную баланса счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер для изменения баланса счета
     * @param balance принимает переменную баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    /**
     * Переопределение метода сравнения для модели данных Account для сравнения реквизитов счета
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    /**
     * Переопределение hashCode для модели данных Account
     */
    public int hashCode() {
        return Objects.hash(requisite);
    }
}