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
    private final List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
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
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                item.setId(id);
                items.set(index, item);
                result = true;
            }
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
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
                result = true;
            }
        }
        return result;
    }

    /**
     * возвращает массив не нулевых заявок
     * @return массив
     */
    public List<Item> findAll() {
        return this.items;
    }

    /**
     *возвращает массив элементов со значением параметра key в поле name
     * первый цикл - поиск одинаковых значений name для выяснения длины
     * возвращаемого массива
     * @param key строковае значение
     * @return массив
     */
    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }
    /**
     * ищет по id заявку
     * @param id - id искомой заявки
     * @return возвращает заявку, если она найдена
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
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
