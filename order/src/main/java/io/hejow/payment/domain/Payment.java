package io.hejow.payment.domain;

import io.hejow.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {
	private int price;

	private Long orderId;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	@Enumerated(EnumType.STRING)
	private Status status;

	public static Payment card(Long orderId, int price) {
		return new Payment(price, orderId, PaymentMethod.CARD, Status.REQUESTED);
	}

	public static Payment cash(Long orderId, int price) {
		return new Payment(price, orderId, PaymentMethod.CASH, Status.REQUESTED);
	}

	public enum PaymentMethod {
		CARD, CASH;

		public boolean isCard() {
			return this == CARD;
		}
	}

	public enum Status {
		REQUESTED, PAYED
	}
}
