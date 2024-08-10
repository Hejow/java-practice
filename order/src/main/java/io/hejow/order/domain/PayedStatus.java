package io.hejow.order.domain;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PayedStatus implements OrderStatus {
	private final ApplicationEventPublisher eventPublisher;

	@Override
	public void onSuccess(Order order) {
		order.changeStatus(new PlacedStatus());

		eventPublisher.publishEvent(new StartDeliveryEvent());
	}

	@Override
	public void onFail(Order order) {
		throw new IllegalStateException("결제에 실패했습니다.");
	}
}
