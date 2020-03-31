package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.SetEmailObject;

public class TestForgotPassword extends TestSuperClass {
	@Test
	public void enterNonexistentEmail() {
		
		//arrange
		String[] expectedAlert = new String[] {"There is 1 error", "There is no account registered for this email address."};
		
		//act
		String[] actualAlert = new SetEmailObject(driver)
				.goToPage()
				.clickForgotPassword()
				.setPasswordAndRetrieve()
				.getAlertText();
		
		//assert
		//System.out.println(actualAlert[0] + ", " + actualAlert[1]);
		Assert.assertEquals(actualAlert, expectedAlert, "Alert message mismatch! Error.");
		
	}
}