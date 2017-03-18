package pl.sewq.service;

import pl.sewq.payments.PaymentMethod;

public class ShopService {

	private WarehouseStub warehouse;

	public boolean canBeBought() {
		return warehouse.isItemInWarehouse();
	}

	public static boolean checkout(final PaymentMethod paymentMethod) {
		return true;
	}
}
