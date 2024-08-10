package io.hejow.payment.service;

public interface CardPaymentService {
	boolean pay(String cardNumber, int price);
}
