package io.hejow.order.domain;

public interface OrderStatus {
	OrderStatus onSuccess();

	OrderStatus onFail();
}
