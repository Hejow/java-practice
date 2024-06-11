package hejow.java.practice.etc.generic;

import java.util.ArrayList;
import java.util.List;

public class CompileTest {
    public static void main(String[] args) {
        Object[] array = new String[10];
        List<String> list = new ArrayList<>();

        Box itemBox = new Box<>();
        itemBox.add(new Laptop("macBook", 10000));
        itemBox.add(new Phone("iphone", 10000));

        for (Object item : itemBox.getItems()) {
            System.out.println(item);
            System.out.println(item.getClass());
        }
    }
}
