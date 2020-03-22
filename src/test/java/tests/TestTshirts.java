package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.TshirtsObject;

public class TestTshirts extends TestSuperClass {

	@Test
	public void test() {
		//arrange
		String expectedText = "T-SHIRTS ";
		
		//act
		String actualText = new TshirtsObject(driver)
				.goToPage()
				.tShirtsText();
		
		//assert
		Assert.assertEquals(actualText, expectedText, "Wrong Text");
		
	}
	
}
