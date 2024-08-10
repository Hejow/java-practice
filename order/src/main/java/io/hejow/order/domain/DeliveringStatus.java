package io.hejow.order.domain;

public class DeliveringStatus implements OrderStatus {

	@Override
	public void onSuccess(Order order) {
		order.changeStatus(new DeliveredStatus());
	}

	@Override
	public void onFail(Order order) {
		throw new IllegalStateException("배송에 실패했습니다.");
	}
}
