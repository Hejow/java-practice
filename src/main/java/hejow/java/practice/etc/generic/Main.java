package hejow.java.practice.etc.generic;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        Object[] array = new Long[SIZE]; // ok..!
//        List<Object> list = new ArrayList<String>(); // error..!

        Comparator<Item> comparator = (o1, o2) -> o1.getPrice() - o2.getPrice();
        Laptop macBook = new Laptop("MacBook", 3_250_000);
        Phone iPhone13 = new Phone("iPhone13", 850_000);

        int compared = comparator.compare(macBook, iPhone13);
        System.out.println(MessageFormat.format("{0} is expensive than {1} : {2}", macBook.getName(), iPhone13.getName(), compared > 0));

        ItemList<String, Integer> stringIntegerItemList = new ItemList<>();
        ItemList<String, Boolean> stringBooleanItemList = new ItemList<>();
        ItemList<String, Item> stringItemItemList = new ItemList<>();

        System.out.println(isList(stringIntegerItemList));
        System.out.println(isList(stringBooleanItemList));
        System.out.println(isList(stringItemItemList));

        Item iPad = new Item("iPad", 1_000_000);

        // 제네릭 메서드와 제네릭 클래스의 타입 파라미터는 다르다.
//        Box<Integer> integerBox = new Box<>();

        Double zeroPointFour = 0.4;
//        integerBox.printOther(zeroPointFour);

        ItemBox<Phone> pizzaItemBox = new ItemBox<>();
    }

    private static boolean isList(ItemList itemList) {
        return itemList instanceof List<?>;
    }
}
