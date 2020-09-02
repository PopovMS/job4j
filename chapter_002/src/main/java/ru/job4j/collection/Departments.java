package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "", slash = "";
            for (String el : value.split("/")) {
                start += slash + el;
                 tmp.add(start);
                 slash = "/";
            }
        }
        List<String> rsl = new ArrayList<>(tmp);
        sortAsc(rsl);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}