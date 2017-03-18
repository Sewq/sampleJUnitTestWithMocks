package pl.sewq.service.payments;

import static org.assertj.core.api.Assertions.assertThat;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;
import org.powermock.reflect.Whitebox;

import pl.sewq.Item.Item;
import pl.sewq.service.ShopService;
import pl.sewq.service.payments.Cart;

public class CartTest {

	private final static Item SAMPLE_ITEM = new Item("itemName", 2);

	private ShopService shopService;
	private Cart cart;

	@Before
	public void setup() {
		cart = new Cart();
		shopService = PowerMock.createMock(ShopService.class);
		Whitebox.setInternalState(cart, shopService);
	}

	@Test
	public void testAddingItemToCartWhenAvailable_shouldAdd() {
		EasyMock.expect(shopService.canBeBought()).andReturn(true);

		PowerMock.replayAll();
		cart.putItemToCart(SAMPLE_ITEM);
		PowerMock.verifyAll();

		assertThat(cart.getCartRemainingCapacity()).isEqualTo(9);
	}

	@Test
	public void testAddingItemToCartWhenNotAvailable_shouldNotAdd() {
		EasyMock.expect(shopService.canBeBought()).andReturn(false);

		PowerMock.replayAll();
		cart.putItemToCart(SAMPLE_ITEM);
		PowerMock.verifyAll();

		assertThat(cart.getCartRemainingCapacity()).isEqualTo(10);
		assertThat(cart.getItems()).isEmpty();
	}
}
