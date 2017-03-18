package pl.sewq.Item;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Item {

	private final String name;
	private int quantity;
	private boolean isAvailable;

	public Item(final String name, final int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getItemName() {
		return name;
	}

	public int getItemAmount() {
		return quantity;
	}

	public void addQuantity(final int amount) {
		quantity += amount;
	}

	public void removeQuantity(final int amount) {
		if (quantity >= amount) {
			quantity -= amount;
		} else {
			System.out.println("Missing items: " + (amount - quantity));
			quantity = 0;
		}
	}

	public boolean isItemAvailable() {
		return quantity > 0;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(quantity)
		        .append(isAvailable).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Item that = (Item) obj;
		return new EqualsBuilder().append(name, that.name)
		        .append(quantity, that.quantity).isEquals();
	}

	public void setQuantityToZero() {
		quantity = 0;
	}

}
