package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        value = value / 70;
        return value;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        value = value / 60;
        return value;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value Евро.
     * @return рубли.
     */
    public int EuroToRuble(int value) {
        value = value * 70;
        return value;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли
     */
    public int DollarToRuble(int value) {
        value = value * 60;
        return value;
    }
}
