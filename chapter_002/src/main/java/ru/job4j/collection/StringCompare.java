package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] vol1 = left.toCharArray();
        char[] vol2 = right.toCharArray();
        int result = 0;
        int minLen = vol1.length < vol2.length ? vol1.length : vol2.length;
        int maxLen = vol1.length > vol2.length ? vol1.length : vol2.length;
        for (int index = 0; index < minLen; index++) {
            result = Character.compare(vol1[index], vol2[index]);
            if (result != 0) {
                break;
            } else {
                if (index == minLen - 1 && minLen != maxLen) {
                    result = vol1.length < vol2.length ? -1 : 1;
                }
            }
        }
        return result;
    }
}