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

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws MenuOutException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
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
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }

    private String menu = "0. Add new item.\r\n"
                        + "1. Show all items.\r\n"
                        + "2. Edit item.\r\n"
                        + "3. Delete item.\r\n"
                        + "4. Find item by Id.\r\n"
                        + "5. Find items by name.\r\n"
                        + "6. Exit Program.\r\n";

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
                                        + String.format("%d. name: %s, desc: %s, id: %s", 0, item.getName(), item.getDecs(), item.getId()) + "\r\n"
                                        + String.format("%d. name: %s, desc: %s, id: %s", 1, item2.getName(), item2.getDecs(), item2.getId()) + "\r\n")
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
                                        + "--Found item with this id--\r\n"
                                        + String.format(" name: %s, desc: %s, id: %s", item.getName(), item.getDecs(), item.getId()) + "\r\n")
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
                                        + "--Found items with this name--\r\n"
                                        + String.format("%d. name: %s, desc: %s, id: %s", 0, item.getName(), item.getDecs(), item.getId()) + "\r\n")
                                .toString()
                )
        );
    }
}
