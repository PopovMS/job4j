package ru.job4j.tracker;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для вывода всех заявок
     */
    private static final String SHOW = "1";

    /**
     * Константа для редактирования заявки
     */
    private static final String EDIT = "2";

    /**
     * Константа для удаления заявки
     */
    private static final String DELETE = "3";

    /**
     * константа для поиска по id
     */
    private static final String FINDBYID = "4";

    /**
     * константа для поиска по имени
     */
    private static final String FINDBYNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.fidnByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавление новой заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long created = System.currentTimeMillis();
        Item item = new Item(name, desc, created);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок в консоль
     */
    private void showAllItem() {
        System.out.println("------------ Вывод всех заявок --------------");
        int numItem = 0;
        for (Item item : this.tracker.findAll()) {
            System.out.println(String.format("%d. name: %s, desc: %s, id: %s", numItem++, item.getName(), item.getDecs(), item.getId()));
        }
    }

    /**
     * метод ищет заявку и заменяет ее на новую
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String itemId = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(itemId);
        if (item != null) {
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите описание заявки :");
            item.setName(name);
            item.setDecs(desc);
            this.tracker.replace(item.getId(), item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }

    }

    /**
     * метод удаляет заявку
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------------");
        String itemId = this.input.ask("Введите id заявки :");
        if (this.tracker.delete(itemId)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка с таким id не найдена");
        }

    }

    /**
     * Метод вызывает поиск заявки по id
     */
    private void fidnByIdItem() {
        System.out.println("------------ поиск заявки по id------------------");
        String itemId = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(itemId);
        if (item != null) {
            System.out.println(String.format("name: %s, desc: %s, id: %s", item.getName(), item.getDecs(), item.getId()));
        } else {
            System.out.println("Заявка с id: " + itemId + " не найдена");
        }

    }

    /**
     * поиск заявок по имени и вывод
     */
    private void findByNameItem() {
        System.out.println("------------ поиск заявки по имени------------------");
        String itemName = this.input.ask("Введите имя заявки :");
        Item[] arr = this.tracker.findByName(itemName);
        if (arr.length != 0) {
            int numItem = 0;
            System.out.println("--Найдено заявок с этим именем--");
            for (Item item : arr) {
                System.out.println(String.format("%d. name: %s, desc: %s, id: %s", numItem++, item.getName(), item.getDecs(), item.getId()));
            }
        } else {
            System.out.println("Заявка с таким именем не найдена");
        }
    }

    /**
     * Метод выводит в консоль основное меню программы
     */
    private void showMenu() {
        System.out.println("------------ Меню------------------");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    /**
     * Запускт программы.
     * @param args массив с параметрами
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
