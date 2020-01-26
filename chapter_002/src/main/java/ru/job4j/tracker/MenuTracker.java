package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;


class AddItem extends BaseAction {

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please, provide item name:");
        String desc = input.ask("Please, provide item description:");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ New Item with Id : " + item.getId());
        System.out.println("------------ New Item with Name : " + item.getName());
        System.out.println("------------ New Item with Description : " + item.getDecs());
    }
}

class FindAllItem extends BaseAction {

    public FindAllItem(int key, String name) {
        super(key, name);
    }
        @Override
        public void execute(Input input, Tracker tracker) {
            int numItem = 0;
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%d. name: %s, desc: %s, id: %s", numItem++, item.getName(), item.getDecs(), item.getId()));
            }
        }
}

    class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String itemId = input.ask("Please, provide item id:");
            if (tracker.findById(itemId) != null) {
                String name = input.ask("Please, provide item name:");
                String desc = input.ask("Please, provide item description:");
                Item item = new Item(name, desc);
                tracker.replace(itemId, item);
                System.out.println("------------ Item with Id : " + item.getId());
                System.out.println("------------ New Item Name : " + item.getName());
                System.out.println("------------ New Item Description : " + item.getDecs());
            } else {
                System.out.println("------------ Item with Id " + itemId + " not found");
            }
        }
    }

    class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String itemId = input.ask("Please, provide item id:");
            if (tracker.delete(itemId)) {
                System.out.println("------------ Item with Id " + itemId + " removed");
            } else {
                System.out.println("------------ Item with Id " + itemId + " not found");
            }
        }
    }

    class FindByIdItem extends BaseAction {

        public FindByIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String itemId = input.ask("Please, provide item id:");
            Item item = tracker.findById(itemId);
            if (item != null) {
                System.out.println("--Found item with this id--");
                System.out.println(String.format(" name: %s, desc: %s, id: %s", item.getName(), item.getDecs(), item.getId()));
            } else {
                System.out.println("------------ Item with id " + itemId + " not found");
            }
        }
    }

    class FindByNameItem extends BaseAction {

        public FindByNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String itemName = input.ask("Please, provide item name:");
            List<Item> arr = tracker.findByName(itemName);
            if (arr.size() != 0) {
                int numItem = 0;
                System.out.println("--Found items with this name--");
                for (Item item : arr) {
                    System.out.println(String.format("%d. name: %s, desc: %s, id: %s", numItem++, item.getName(), item.getDecs(), item.getId()));
                }
            } else {
                System.out.println("------------ Item with name " + itemName + " not found");
            }
        }
    }

class ExitProgram extends BaseAction {

    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }
}

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new item."));
        this.actions.add(new FindAllItem(1, "Show all items."));
        this.actions.add(new UpdateItem(2, "Edit item."));
        this.actions.add(new DeleteItem(3, "Delete item."));
        this.actions.add(new FindByIdItem(4, "Find item by Id."));
        this.actions.add(new FindByNameItem(5, "Find items by name."));
        this.actions.add(new ExitProgram(6, "Exit Program."));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}