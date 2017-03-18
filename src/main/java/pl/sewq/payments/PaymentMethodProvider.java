package pl.sewq.payments;

import pl.sewq.service.PaymentService;

public class PaymentMethodProvider {

	public static PaymentService getPayment(final PaymentMethod paymentMethod) {
		return paymentMethod.getPaymentService();
	}

}
