package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.ExistingEmailObject;

public class TestCreateAccountExistingEmail extends TestSuperClass {
	@Test
	public void accountCreation() {
		//arrange
		String expectedAlert = new String("An account using this email address has already been registered. Please enter a valid password or request a new one.");
		
		//act
		String actualAlert = new ExistingEmailObject(driver)
				.goToPage()
				.clickSignIn()
				.enterUsedEmailAndSubmit()
				.getAlertText();
		
		//assert
		//System.out.println("actualAlert = " + actualAlert);
		Assert.assertEquals(actualAlert, expectedAlert, "Alert mismatch! Error.");
	}
}
