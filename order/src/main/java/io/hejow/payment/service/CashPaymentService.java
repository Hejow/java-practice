package io.hejow.payment.service;

public interface CashPaymentService {
	boolean pay(String cardNumber, int price);
}
