package io.hejow.order.domain;

import io.hejow.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderLine extends BaseEntity {
	private String name;

	private int quantity;

	private int price;
}
