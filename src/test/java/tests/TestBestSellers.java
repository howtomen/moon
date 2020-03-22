package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.BestSellersObject;


public class TestBestSellers extends TestSuperClass {

	@Test
	public void test() {
		
		String expectedText = "BEST SELLERS";
		
		String actualText = new BestSellersObject(driver)
				.goToPage()
				.bestSellers();
		
		Assert.assertEquals(actualText, expectedText, "Wrong Text");
		
	}
	
}
