package io.hejow.delivery.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import io.hejow.delivery.domain.Delivery;
import io.hejow.delivery.domain.DeliveryRepository;
import io.hejow.delivery.domain.Receiver;
import io.hejow.delivery.domain.ShippingInfo;
import io.hejow.eda.PaySuccessEvent;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DeliveryService {
	private final DeliveryRepository deliveryRepository;

	@TransactionalEventListener
	public void onOrderPayed(PaySuccessEvent event) {
		var receiver = new Receiver("", "");

		var shippingInfo = new ShippingInfo("", "");

		Delivery.requested(event.orderId(), receiver, shippingInfo);
	}
}
