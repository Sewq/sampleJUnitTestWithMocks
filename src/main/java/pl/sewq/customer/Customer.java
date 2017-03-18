package pl.sewq.customer;

import pl.sewq.Item.Item;
import pl.sewq.payments.PaymentMethod;
import pl.sewq.payments.PaymentMethodProvider;
import pl.sewq.service.PaymentService;
import pl.sewq.service.payments.Cart;

public class Customer {

	private Cart shoppingCart;
	private PaymentMethod paymentMethod;
	private PaymentService paymentService;

	public void putItemToCart(final Item item) {
		shoppingCart.putItemToCart(item);
	}

	public String checkout() {
		getPaymentMethod();
		return paymentService.payForPurchases(paymentMethod);
	}

	private void getPaymentMethod() {
		paymentService = PaymentMethodProvider.getPayment(paymentMethod);
	}

	public void setPaymentMethod(final PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}
