package io.hejow.order.dto;

import java.util.List;

public sealed interface OrderRequest permits OrderRequest.Create {
	record Create(
		List<Menu> menus
	) implements OrderRequest {
	}

	record Menu(
		String name,
		int quantity,
		int price
	) {
	}
}
