package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test2", "testDesc2", created);
        tracker.add(item);
        tracker.replace(item.getId(), item2);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item2.getName()));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test2", "testDesc2", created);
        Item item3 = new Item("test3", "testDesc3", created);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Boolean result = true;
        assertThat(result, is(tracker.delete(item3.getId())));
    }
    @Test
    public void whenReturnAllItems() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test2", "testDesc2", created);
        Item item3 = new Item("test3", "testDesc3", created);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findAll();
        List<Item> expect = Arrays.asList(item, item2, item3);
        assertThat(result, is(expect));
    }
    @Test
    public void whenFindItemsByName() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test1", "testDesc2", created);
        Item item3 = new Item("test3", "testDesc3", created);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName("test1");
        List<Item> expect = Arrays.asList(item, item2);
        assertThat(result, is(expect));
    }
    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        Item item2 = new Item("test2", "testDesc2", created);
        Item item3 = new Item("test3", "testDesc3", created);
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(item3.getId());
        assertThat(result, is(item3));
    }
}