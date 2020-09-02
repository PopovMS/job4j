package ru.job4j.collection;

import java.util.*;

/**
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class Departments {
    /**
     * принимает коллекцию, формирует список упорядоченных подразделений
     * @param deps - входящая коллекция
     * @return - отсортированная коллекция
     */

    public static List<String> fillGaps(List<String> deps) {
        TreeSet<String> tmp = new TreeSet<>();
        for (String value : deps) {
            String start = "", slash = "";
            for (String el : value.split("/")) {
                start += slash + el;
                 tmp.add(start);
                 slash = "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}