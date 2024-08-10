package io.hejow.order.domain;

import java.util.ArrayList;
import java.util.List;

import io.hejow.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

	@Convert(converter = StatusConverter.class)
	private OrderStatus status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderLine> orderLines = new ArrayList<>();

	public static Order placed(List<OrderLine> orderLines) {
		return new Order(new PlacedStatus(), orderLines);
	}

	public void changeStatus() {
		this.status = status.onSuccess();
	}

	public enum Status {
		PLACED,
		PAYED,
		DELIVERED,
		CANCELED
	}
}
