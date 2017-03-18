package pl.sewq.service;

import pl.sewq.payments.PaymentMethod;

public class CreditCard implements PaymentService {

	public String payForPurchases(final PaymentMethod paymentMethod) {
		return "Payment with credit card successed";
	}

}
