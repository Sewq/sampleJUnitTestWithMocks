package pl.sewq.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import pl.sewq.Item.Item;
import pl.sewq.payments.PaymentMethod;
import pl.sewq.payments.PaymentMethodProvider;
import pl.sewq.service.PaymentService;
import pl.sewq.service.payments.Cart;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PaymentMethodProvider.class)
public class CustomerTest {

	private static final String PURCHASE_SUCCESS = "success";
	private static final Item SAMPLE_ITEM = new Item("1", 1);
	private Customer customer;
	private Cart cart;
	private PaymentService paymentService;
	private PaymentMethod paymentMethod;

	@Before
	public void setup() {
		customer = new Customer();
		paymentMethod = PaymentMethod.CASH;
		paymentService = PowerMock.createMock(PaymentService.class);
		cart = PowerMock.createMock(Cart.class);
		PowerMock.mockStatic(PaymentMethodProvider.class);
		Whitebox.setInternalState(customer, paymentService, cart,
		        paymentMethod);
	}

	@Test
	public void testPuttingItemToCart() {
		cart.putItemToCart(SAMPLE_ITEM);
		PowerMock.replayAll();
		customer.putItemToCart(SAMPLE_ITEM);
		PowerMock.verifyAll();
	}

	@Test
	public void testCheckoutFlow() {
		EasyMock.expect(PaymentMethodProvider.getPayment(PaymentMethod.CASH))
		        .andReturn(paymentService);
		EasyMock.expect(paymentService.payForPurchases(paymentMethod))
		        .andReturn(PURCHASE_SUCCESS);
		PowerMock.replayAll();
		assertThat(customer.checkout()).isEqualTo(PURCHASE_SUCCESS);
		PowerMock.verifyAll();
	}
}
