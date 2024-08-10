package io.hejow.payment.service;

import static io.hejow.payment.domain.Payment.*;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import io.hejow.eda.OrderEvent;
import io.hejow.eda.PayFailEvent;
import io.hejow.eda.PaySuccessEvent;
import io.hejow.payment.domain.PaymentRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaymentService {
	private final PaymentRepository paymentRepository;
	private final CardPaymentService cardPaymentService;
	private final CashPaymentService cashPaymentService;

	private final ApplicationEventPublisher eventPublisher;

	@TransactionalEventListener
	public void onOrderRequested(OrderEvent orderEvent) {
		var paymentMethod = PaymentMethod.valueOf(orderEvent.paymentMethod());

		var payment = paymentMethod.isCard()
			? card(orderEvent.orderId(), orderEvent.price())
			: cash(orderEvent.orderId(), orderEvent.price());

		paymentRepository.save(payment);

		var success = paymentMethod.isCard()
			? cardPaymentService.pay("", orderEvent.price())
			: cashPaymentService.pay("", orderEvent.price());

		var orderId = orderEvent.orderId();

		var event = success ? new PaySuccessEvent(orderId) : new PayFailEvent(orderId);

		eventPublisher.publishEvent(event);
	}
}
