package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.ReturnToHomePageObject;

public class TestReturnToHomePage extends TestSuperClass {
	
	@Test
	public void test() {
		//arrange
		String expectedHomepageText = "POPULAR";
		
		//act
		String actualHomepageText = new ReturnToHomePageObject(driver)
				.goToPage()
				.clickTshirts()
				.clickYourLogo()
				.returnText();
		
		//assert
		Assert.assertEquals(actualHomepageText, expectedHomepageText, "If text do not match, you have not returned to the homepage!");
	}
}
