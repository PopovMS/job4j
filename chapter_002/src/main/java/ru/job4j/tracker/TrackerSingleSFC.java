package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleSFC {
    private TrackerSingleSFC() {
    }

    public static TrackerSingleSFC getInstance() {
        return Holder.INSTANCE;
    }

    Tracker tracker = new Tracker();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * Метод реализующий замену ячейки в массиве
     * @param id искомый id заявки, которая подлежить замене
     * @param item заявка, которой заменяем
     * @return результат
     */
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * Метод находит заявку по id, удалеяет ее, и смещает все остальные заявки на одну влево
     * @param id принимает id заявки
     * @return возвращает true по удачному завершению
     */
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    /**
     * возвращает массив не нулевых заявок
     * @return массив
     */
    public List<Item> findAll() {
        return tracker.findAll();
    }

    /**
     *возвращает массив элементов со значением параметра key в поле name
     * первый цикл - поиск одинаковых значений name для выяснения длины
     * возвращаемого массива
     * @param key строковае значение
     * @return массив
     */
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
    /**
     * ищет по id заявку
     * @param id - id искомой заявки
     * @return возвращает заявку, если она найдена
     */
    public Item findById(String id) {
        return tracker.findById(id);
    }

    private static final class Holder {
        private static final TrackerSingleSFC INSTANCE = new TrackerSingleSFC();
    }
}
