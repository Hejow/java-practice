package hejow.java.practice.etc.generic;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Item> {
    private List<T> items = new ArrayList<>();

    public void add(T t) {
        items.add(t);
    }

    public void extend(List<? extends T> list) {
        items.addAll(list);
    }

    public void printAll(List<? extends Item> list) {
        for (Item o : list) {
            System.out.println(o);
        }
    }

    public <T> void printOther(T e) {
        System.out.println(e);
    }

    public List<T> getItems() {
        return items;
    }
}
