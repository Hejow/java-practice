package hejow.java.practice.etc.tda.after;

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
        orderItems.forEach(shop::validateItem);
    }

    private int calculateTotalPrice(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(OrderItem::price)
                .reduce(0, Integer::sum);
    }
}
