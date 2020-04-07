package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.ItemRemovalFromHomeObject;

public class TestItemRemovalFromHome extends TestSuperClass {
	
	@Test
	public void canRemoveItemFromHomeScreen() {
		boolean actualItemRemoved = new ItemRemovalFromHomeObject(driver)
				.goToPage()
				.addToCart("Faded Short Sleeve T-shirts")
				.confirmItemInCart("Faded Short Sleeve T-shirts")
				.removeFromCart("Faded Short Sleeve T-shirts")
				.confirmItemRemoved("Faded Short Sleeve T-shirts");
		
		boolean expectedItemRemoved = true;
		
		Assert.assertEquals(actualItemRemoved, expectedItemRemoved, "Item not successfully removed.");
	}

}

