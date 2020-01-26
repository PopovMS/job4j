package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class OrderConvert {
    /**
     * Преобразует список заявок в карту HashMap
     * @param orders получает список заявок
     * @return возвращает карту HashMap
     */
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order order : orders) {
            map.put(order.getNumber(), order);
        }
        return map;
    }
}