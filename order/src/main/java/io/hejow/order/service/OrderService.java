package io.hejow.order.service;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import io.hejow.eda.OrderEvent;
import io.hejow.eda.PaySuccessEvent;
import io.hejow.order.domain.Order;
import io.hejow.order.domain.OrderLine;
import io.hejow.order.domain.OrderRepository;
import io.hejow.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
	private final OrderRepository orderRepository;

	private final ApplicationEventPublisher eventPublisher;

	@Transactional
	public void placeOrder(List<OrderRequest.Menu> menus, String paymentMethod) {
		var orderLines = menus.stream()
			.map(it -> new OrderLine(it.name(), it.quantity(), it.price()))
			.toList();

		var totalPrice = menus.stream()
			.reduce(0, (acc, it) -> acc + it.price() * it.quantity(), Integer::sum);

		var order = orderRepository.save(Order.placed(orderLines));

		eventPublisher.publishEvent(new OrderEvent(order.getId(), totalPrice, paymentMethod));
	}

	@TransactionalEventListener
	public void onPaySuccess(PaySuccessEvent event) {
		var order = orderRepository.findById(event.orderId()).orElseThrow();

		order.payed();
	}
}
