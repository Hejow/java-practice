package io.hejow.external;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.hejow.payment.service.CardPaymentService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class KakaoCardPaymentService implements CardPaymentService {

	private final Map<String, Integer> cards = List.of("1234-1234-1234-1234", "5678-5678-5678-5678").stream()
		.collect(Collectors.toMap(
			cardNumber -> cardNumber,
			cardNumber -> ThreadLocalRandom.current().nextInt(1000) * 10)
		);

	@Override
	public boolean pay(String cardNumber, int price) {
		if (cards.containsKey(cardNumber)) {
			var balance = cards.get(cardNumber);

			if (balance >= price) {
				cards.put(cardNumber, balance - price);
				return true;
			}

			return false;
		}

		return false;
	}
}
