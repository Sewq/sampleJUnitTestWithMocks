package pl.sewq.service.payments;

import pl.sewq.payments.PaymentMethod;
import pl.sewq.service.PaymentService;

public class Cash implements PaymentService {

	public String payForPurchases(final PaymentMethod paymentMethod) {
		return "Payment with Cash successed";
	}

}
