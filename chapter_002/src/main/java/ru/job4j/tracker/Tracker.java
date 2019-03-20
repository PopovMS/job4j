package ru.job4j.tracker;

import java.util.*;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод реализующий замену ячейки в массиве
     * @param id искомый id заявки, которая подлежить замене
     * @param item заявка, которой заменяем
     * @return результат
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = findIndexById(id);
        if (index > -1) {
            item.setId(id);
            this.items[index] = item;
            result = true;
        }
        return result;
    }

    /**
     * Метод находит заявку по id, удалеяет ее, и смещает все остальные заявки на одну влево
     * @param id принимает id заявки
     * @return возвращает true по удачному завершению
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = findIndexById(id);
            if (index > -1) {
                this.items[index] = null;
                System.arraycopy(this.items, index + 1, this.items, index, this.items.length - index - 1);
                this.items[findIndexLastItem()] = null;
                result = true;
            }
        return result;
    }

    /**
     * возвращает массив не нулевых заявок
     * @return массив
     */
    public Item[] findAll() {
        Item[] result = new Item[findIndexLastItem() + 1];
        System.arraycopy(this.items, 0, result, 0, result.length);
        return result;
    }

    /**
     *возвращает массив элементов со значением параметра key в поле name
     * первый цикл - поиск одинаковых значений name для выяснения длины
     * возвращаемого массива
     * @param key строковае значение
     * @return массив
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (int index = 0; index <= findIndexLastItem(); index++) {
            if (this.items[index].getName().equals(key)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        count = 0;
        for (int index = 0; index < findIndexLastItem(); index++) {
            if (this.items[index].getName().equals(key)) {
                result[count++] = this.items[index];
            }
        }
        return result;
    }
    /**
     * ищет по id заявку
     * @param id - id искомой заявки
     * @return возвращает заявку, если она найдена
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index <= findIndexLastItem(); index++) {
            if (this.items[index].getId().equals(id)) {
                result = this.items[index];
                break;
            }
        }
        return result;
    }

    /**
     * ищет index массива по id заявки
     * @param id - id искомой заявки
     * @return index заявки
     */
    private int findIndexById(String id) {
        int result = -1;
        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }

    /**
     * поиск последнего не пустого элемента массива
     * @return index последнего значения
     */
    private int findIndexLastItem() {
        int result = items.length - 1;
        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index] == null) {
                result = index - 1;
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
