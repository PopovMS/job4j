package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortItemTest {
    @Test
    public void whenAbcSort() {
        List<Item> items = Arrays.asList(
        new Item("Btest", "testDescription"),
        new Item("Atest", "testDesc2"),
        new Item("Ctest", "testDesc3")
        );
        Collections.sort(items, new SortByNameItem());
        List<Item> result = Arrays.asList(
                new Item("Atest", "testDesc2"),
                new Item("Btest", "testDescription"),
                new Item("Ctest", "testDesc3")
        );
        assertThat(result, is(items));
    }
    @Test
    public void whenCbaSort() {
        List<Item> items = Arrays.asList(
                new Item("Btest", "testDescription"),
                new Item("Atest", "testDesc2"),
                new Item("Ctest", "testDesc3")
        );
        Collections.sort(items, new SortByNameItem().reversed());
        List<Item> result = Arrays.asList(
                new Item("Ctest", "testDesc3"),
                new Item("Btest", "testDescription"),
                new Item("Atest", "testDesc2")
        );
        assertThat(result, is(items));
    }

}
