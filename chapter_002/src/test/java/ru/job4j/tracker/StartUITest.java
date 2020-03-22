package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final String separator = System.getProperty("line.separator");

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws MenuOutException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasUpdatedArray() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name2"));
    }

    private String menu = "0. Add new item."
                        + separator + "1. Show all items."
                        + separator + "2. Edit item."
                        + separator + "3. Delete item."
                        + separator + "4. Find item by Id."
                        + separator + "5. Find items by name."
                        + separator + "6. Exit Program.";

    @Test
    public void whenShowAllItems() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(menu
                                        + separator + String.format("%d. name: %s, desc: %s, id: %s", 0, item.getName(), item.getDecs(), item.getId())
                                        + separator + String.format("%d. name: %s, desc: %s, id: %s", 1, item2.getName(), item2.getDecs(), item2.getId()) + separator)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemById() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test name2", "desc2"));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(menu
                                        + separator + "--Found item with this id--"
                                        + separator + String.format(" name: %s, desc: %s, id: %s", item.getName(), item.getDecs(), item.getId()) + separator)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByName() throws MenuOutException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                Is.is(
                        new StringBuilder()
                                .append(menu
                                        + separator + "--Found items with this name--"
                                        + separator + String.format("%d. name: %s, desc: %s, id: %s", 0, item.getName(), item.getDecs(), item.getId()) + separator)
                                .toString()
                )
        );
    }
}
