package hejow.java.practice.etc.tda.after;

import java.util.List;

public record Shop(String name, List<OrderItem> items) {
    public void validateItem(OrderItem orderItem) {
        if (!items.contains(orderItem)) {
            throw new IllegalArgumentException("매장에 없는 아이템입니다. item : " + orderItem);
        }
    }
}
