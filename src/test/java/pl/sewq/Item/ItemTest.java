package pl.sewq.Item;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import pl.sewq.Item.Item;

public class ItemTest {
	private final String ITEM_NAME = "itemName";
	private final int ITEM_INITIAL_QUANTITY = 3;
	private final int ITEM_EXPECTED_ADD_QUANTITY = 5;
	private final int ITEM_EXPECTED_REMOVE_QUANTITY = 1;

	private Item testItem;

	@Before
	public void setup() {
		testItem = new Item(ITEM_NAME, ITEM_INITIAL_QUANTITY);
	}

	@Test
	public void testItemQuantity_shouldBeMoreAfterAddingQuantity() {
		assertThat(testItem.getItemAmount()).isEqualTo(ITEM_INITIAL_QUANTITY);
		testItem.addQuantity(2);
		assertThat(testItem.getItemAmount())
		        .isEqualTo(ITEM_EXPECTED_ADD_QUANTITY);
	}

	@Test
	public void testItemQuantity_shouldRemoveQuantity() {

		assertThat(testItem.getItemAmount()).isEqualTo(ITEM_INITIAL_QUANTITY);
		testItem.removeQuantity(2);
		assertThat(testItem.getItemAmount())
		        .isEqualTo(ITEM_EXPECTED_REMOVE_QUANTITY);
	}

	@Test
	public void testItemQuantity_quantityShouldBeZero() {
		assertThat(testItem.getItemAmount()).isEqualTo(ITEM_INITIAL_QUANTITY);
		testItem.removeQuantity(6);
		assertThat(testItem.getItemAmount()).isEqualTo(0);
	}

	@Test
	public void testItemAvailibility_shouldBeAvailable() {
		assertThat(testItem.isItemAvailable()).isTrue();
	}

	@Test
	public void testItemAvailibility_shouldNotBeAvailable() {
		testItem.removeQuantity(ITEM_INITIAL_QUANTITY);
		assertThat(testItem.isItemAvailable()).isFalse();
	}
}
