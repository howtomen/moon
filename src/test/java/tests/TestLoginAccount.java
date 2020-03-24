package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.LoginPageObject;

public class TestLoginAccount extends TestSuperClass {
	
	// As a User
	// I want to be able to log back in to my account
	// So I can save my information
	@Test
	public void loginUserCorrectly() {
		String WebEmail = new devKey().getValidWebEmail();
		String WebPassword = new devKey().getValidWebPassword();
		
		String expectedSignedInText = new devKey().getCustomerName();
		
		String actualSignedInText = new LoginPageObject(driver)
				.goToPage()
				.enterLoginInfo(WebEmail, WebPassword)
				.clickSignInButton()
				.getSignedInText();

		Assert.assertEquals(actualSignedInText, expectedSignedInText, "Failed to login to Account");
	}
}
