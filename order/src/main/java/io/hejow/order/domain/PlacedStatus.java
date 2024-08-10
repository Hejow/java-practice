package io.hejow.order.domain;

public class PlacedStatus implements OrderStatus {

	@Override
	public OrderStatus onSuccess() {
		return null;
	}

	@Override
	public OrderStatus onFail() {
		throw new IllegalStateException("결제에 실패했습니다.");
	}
}
