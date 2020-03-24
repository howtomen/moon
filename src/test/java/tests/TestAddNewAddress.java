package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.LoginPageObject;

public class TestAddNewAddress extends TestSuperClass {
	
	// As a 'Frequent Traveler'
	// I want to 'Add a new my address'
	// So that 'I can get my easily change my delivery address'
	@Test
	public void addingNewUserAddress() {
		String WebEmail = new devKey().getValidWebEmail();
		String WebPassword = new devKey().getValidWebPassword();

		String[] expectedSignedInText = {"123-45 Quintrix Dr.", "Queens", "New York", "11010", "3334445555", "Fake Address"};

		String[] actualSignedInText = new LoginPageObject(driver)
				.goToPage()
				.enterLoginInfo(WebEmail, WebPassword)
				.clickSignInButton()
				.clickMyAddressButton()
				.clickAddNewAddressButton()
				.fillOutNewAddressFormAndSave(expectedSignedInText)
				.ConfirmAddressAndDelete();

		// assert
		for(int i=0; i < expectedSignedInText.length; i++) {
			Assert.assertEquals(actualSignedInText[i].toUpperCase(), expectedSignedInText[i].toUpperCase(), "Add new Address test failed");
		}
	}
}
