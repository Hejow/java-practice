package io.hejow.order.domain;

import jakarta.persistence.AttributeConverter;

public class StatusConverter extends AttributeConverter<OrderStatus, Order.Status> {

	@Override
	public Order.Status convertToDatabaseColumn(OrderStatus orderStatus) {
		return switch (orderStatus) {
			case PLACED -> Order.Status.PLACED;
			case PAYED -> Order.Status.PAYED;
			case DELIVERED -> Order.Status.DELIVERED;
			case CANCELED -> Order.Status.CANCELED;
		};
	}

	@Override
	public OrderStatus convertToEntityAttribute(Order.Status status) {
		return switch (status) {
			case PLACED -> OrderStatus.PLACED;
			case PAYED -> OrderStatus.PAYED;
			case DELIVERED -> OrderStatus.DELIVERED;
			case CANCELED -> OrderStatus.CANCELED;
		};
	}
}
