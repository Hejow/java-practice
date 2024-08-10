package io.hejow.delivery.domain;

import io.hejow.common.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends BaseEntity {
	private Long orderId;

	@Embedded
	private Receiver receiver;

	@Embedded
	private ShippingInfo shippingInfo;

	@Enumerated(EnumType.STRING)
	private Status status;

	public static Delivery requested(Long orderId, Receiver receiver, ShippingInfo shippingInfo) {
		return new Delivery(orderId, receiver, shippingInfo, Status.REQUESTED);
	}

	public enum Status {
		REQUESTED, DELIVERING, DELIVERED
	}
}
