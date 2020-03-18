package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRemoveItem extends TestSuperClass {

	@Test
	public void canRemoveItemFromCart() throws CartException {
		
		boolean actual = new RemoveItemObject(driver)
				.goToPage()
				.addItemsToCart()
				.confirmItemIsInCart()
				.removeItemFromCart()
				.confirmItemIsRemoved();

		boolean expected = true;

		Assert.assertEquals(actual, expected, "Blouse still in cart");
	}

}
