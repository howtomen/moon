package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.QuantityLimitObject;

public class TestQuantityLimit extends TestSuperClass {
	
	@Test
	public void isQuantityLimited() throws InterruptedException {
		String actualQuantity = new QuantityLimitObject(driver)
				.goToPage()
				.addToCart("Blouse")
				.goToCart()
				.setQuantity("9999999999")
				.getActualQuantity();
		
		String expectedQuantity = "4294967295";
		
		Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity not defaulting correctly");
	}

}
