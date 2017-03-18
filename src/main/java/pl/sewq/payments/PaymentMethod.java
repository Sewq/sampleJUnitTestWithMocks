package pl.sewq.payments;

import pl.sewq.service.CreditCard;
import pl.sewq.service.PaymentService;
import pl.sewq.service.payments.Cash;
import pl.sewq.service.payments.Online;

public enum PaymentMethod {
	CREDIT_CARD(new CreditCard()), CASH(new Cash()), ONLINE(new Online());

	private PaymentService paymentService;

	private PaymentMethod(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}
}
