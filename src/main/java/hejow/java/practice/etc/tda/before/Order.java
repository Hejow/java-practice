package hejow.java.practice.etc.tda.before;

import java.util.List;

public class Order {
    private final Shop shop;
    private final List<OrderItem> orderItems;
    private final int totalPrice;

    public Order(Shop shop, List<OrderItem> orderItems) {
        this.shop = shop;
        this.orderItems = orderItems;
        this.totalPrice = calculateTotalPrice(orderItems);
    }

    public void validate() {
        orderItems.forEach(item -> {
                    if (!shop.items().contains(item)) {
                        throw new IllegalArgumentException("매장에 없는 아이템입니다. item : " + item);
                    }});
    }

    private int calculateTotalPrice(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem::price)
                .reduce(0, Integer::sum);
    }
}
