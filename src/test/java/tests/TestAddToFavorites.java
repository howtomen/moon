package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.LoginPageObject;

public class TestAddToFavorites extends TestSuperClass {

	// As an 'Avid Window Shopper'
	// I want to 'Add a dress to my favorites and see that it is there'
	// So that 'I can rest assured that all my favorite dresses will be easy to find'
	@Test
	public void AddDress() {
		String WebEmail = new devKey().getValidWebEmail();
		String WebPassword = new devKey().getValidWebPassword();
		
		String expectedItemName = new LoginPageObject(driver)
				.goToPage()
				.enterLoginInfo(WebEmail, WebPassword)
				.clickSignInButton()
				.clickWomenCatagory()
				.clickOnFirstItem()
				.addToWishList()
				.getFirstItemandCloseModels();
		
		String actualItemName = new LoginPageObject(driver)
				.goToPage()
				.GotoMyWishList()
				.getNameOfFirstItemOnListandRemove();
				

		Assert.assertEquals(actualItemName, expectedItemName, "Failed to add item to favorites");
	}
}
