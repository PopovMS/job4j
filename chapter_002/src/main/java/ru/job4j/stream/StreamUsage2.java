package ru.job4j.stream;
import java.util.List;

/**
 * Класс формирует List и получает из него фильтрованный поток
 * с использованием Stream API
 *
 * @author Popov Mikhail (m.popov83@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StreamUsage2 {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream().filter(task -> task.name.contains("Bug"))
                      .filter(task -> task.spent > 30)
                      .map(task -> task.name + " " + task.spent)
                      .forEach(System.out::println);
    }
}
