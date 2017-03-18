package pl.sewq.service.payments;

import pl.sewq.payments.PaymentMethod;
import pl.sewq.service.PaymentService;

public class Online implements PaymentService {

	public String payForPurchases(final PaymentMethod paymentMethod) {
		return "Online payment successed";
	}

}
