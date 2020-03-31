package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.LoginPageObject;

public class TestLoginIncorrectly extends TestSuperClass {
	
	private String InvalidEmail = "athsjuioiiu6y5ehgjyruthj";
	private String InvalidPassword = "badpassword";
	private String WebEmail = new devKey().getValidWebEmail();
	private String WebPassword = new devKey().getValidWebPassword();
	
	// As a User
	// I want try logging in with an invalid email
	// So users cant login with an unregesterd email
	@Test
	public void testInvalidEmailLogin() {
		String expectedErrorMessageText ="There is 1 error Invalid email address.";
		
		String actualErrorMessageText = new LoginPageObject(driver)
				.goToPage()
				.ifLoggedinThenLogout()
				.enterLoginInfo(InvalidEmail, WebPassword)
				.clickSignInButton()
				.getAlertText();

		Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText, "Invalid Email Login Error Message Test Failed");
	}
	
	
	// As a User
	// I want try logging in with an invalid password
	// So users cant login to my account
	@Test
	public void testInvalidPasswordLogin() {
		String expectedErrorMessageText ="There is 1 error Authentication failed.";
		
		String actualErrorMessageText = new LoginPageObject(driver)
				.goToPage()
				.ifLoggedinThenLogout()
				.enterLoginInfo(WebEmail, InvalidPassword)
				.clickSignInButton()
				.getAlertText();

		Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText, "Invalid Password Login Error Message Test Failed");
	}
	
	
	// As a User
	// I want try logging in without an Email
	// So I know that i cant do it
	@Test
	public void testLoginWithNoEmail() {
		String expectedErrorMessageText ="There is 1 error An email address required.";
		
		String actualErrorMessageText = new LoginPageObject(driver)
				.goToPage()
				.ifLoggedinThenLogout()
				.enterLoginInfo("", WebPassword)
				.clickSignInButton()
				.getAlertText();

		Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText, "No Email Login Error Message Test Failed");
	}
	
	
	// As a User
	// I want try logging in without an Email
	// So I knoq that i cant do it
	@Test
	public void testLoginWithNoPassword() {
		String expectedErrorMessageText ="There is 1 error Password is required.";
		
		String actualErrorMessageText = new LoginPageObject(driver)
				.goToPage()
				.ifLoggedinThenLogout()
				.enterLoginInfo(WebEmail, "")
				.clickSignInButton()
				.getAlertText();

		Assert.assertEquals(actualErrorMessageText, expectedErrorMessageText, "No Email Login Error Message Test Failed");
	}
}
