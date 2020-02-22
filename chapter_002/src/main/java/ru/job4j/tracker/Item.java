package ru.job4j.tracker;

import java.util.Comparator;
import java.util.Objects;
import java.util.Collections;

import static java.lang.CharSequence.compare;

public class Item {
    private String id;
    private String name;
    private String decs;
    private long time;

    public Item(String name, String decs, long time) {
        this.name = name;
        this.decs = decs;
        this.time = time;
    }
    public Item(String name, String decs) {
        this.name = name;
        this.decs = decs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id) && time == item.time && Objects.equals(name, item.name) && Objects.equals(decs, item.decs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, decs, time);
    }
    @Override
    public String toString() {
        return "Item{"
                + "name='"
                + name + '\''
                + ", Description="
                + decs + '}';
    }
}
