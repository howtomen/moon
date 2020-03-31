package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.CheckOutObjectPage;
import objects.LoginPageObject;
import objects.PageObjectSuperClass;
import objects.TileObjectSuperClass;

public class TestTermServiceCheckOut extends TestSuperClass {

	// As a 'Store Owner'
	// I want to 'make sure all customer must agree to terms of services before delivery'
	// So that 'the shopping environment can be safe for everyone'
	@Test
	public void tryToBuyWithOutCheckingTerms() {
		String WebEmail = new devKey().getValidWebEmail();
		String WebPassword = new devKey().getValidWebPassword();
		String Tile1 = "//*[@id=\"homefeatured\"]/li[1]";
		
		String expectedText = "You must agree to the terms of service before continuing.";
		
		new LoginPageObject(driver)
			.goToPage()
			.enterLoginInfo(WebEmail, WebPassword)
			.clickSignInButton();

		new PageObjectSuperClass(driver)
			.navigate();

		new TileObjectSuperClass(driver).addToCart(Tile1).checkout();

		String actualText = new CheckOutObjectPage(driver)
				.proceedcheckout()
				.getmodeltext();

		Assert.assertEquals(actualText, expectedText, "Buying item without checking terms box Test failed");
	}
}
