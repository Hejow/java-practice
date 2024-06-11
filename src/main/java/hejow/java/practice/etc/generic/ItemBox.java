package hejow.java.practice.etc.generic;

import java.util.ArrayList;
import java.util.List;

public class ItemBox<T extends Item> {
    private final List<T> items = new ArrayList<>();

    public void addAll(List<? extends T> itemList) {
        items.addAll(itemList);
    }
}
