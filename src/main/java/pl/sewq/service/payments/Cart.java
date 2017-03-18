package pl.sewq.service.payments;

import java.util.ArrayList;
import java.util.List;

import pl.sewq.Item.Item;
import pl.sewq.service.ShopService;

public class Cart {

	private final List<Item> items = new ArrayList<Item>();
	private ShopService service;

	private final int cartCapacity = 10;

	public void putItemToCart(final Item item) {
		if (service.canBeBought() && isRoomInCart()) {
			items.add(item);
		}
	}

	public boolean takeItemFromCart(final Item item) {
		return items.remove(item);
	}

	public List<Item> getItems() {
		return items;
	}

	public int getCartRemainingCapacity() {
		return cartCapacity - items.size();
	}

	private boolean isRoomInCart() {
		return items.size() <= cartCapacity;
	}
}