package io.hejow.eda;

public record OrderEvent(
	Long orderId,
	int price,
	String paymentMethod
) {
}
