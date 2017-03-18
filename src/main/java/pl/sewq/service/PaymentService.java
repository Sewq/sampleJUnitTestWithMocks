package pl.sewq.service;

import pl.sewq.payments.PaymentMethod;

public interface PaymentService {

	String payForPurchases(PaymentMethod paymentMethod);
}
