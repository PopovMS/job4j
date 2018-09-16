package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 */

public class Calculator {

    // Contains result - cюда записывается результат выполнения методов.

    private double result;

    /**
     * Сложение
     * @param first - первый аргумент
     * @param second - второй аргумент
     */

    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание
     * @param first - первый аргумент
     * @param second - второй аргумент
     */

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Деление
     * @param first - первый аргумент
     * @param second - второй аргумент
     */

    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Умножение
     * @param first - первый аргумент
     * @param second - второй аргумент
     */

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод получения результата
     * @return - результат вычислений
     */

    public double getResult() {
        return this.result;
    }
}

