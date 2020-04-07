package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.ContactUsPage;

public class TestCustomerServiceFormIncorrect extends TestSuperClass {
	@Test
	public void CustomerServiceFormIncorrect() {
		String WebEmail = new devKey().getValidWebEmail();
		// arrange
		String expectedConfirmationText = "The message cannot be blank.";

		// act
		String actualResultText = new ContactUsPage(driver)
				.goToPage()
				.chooseDropdownHedding()
				.enterEmailOnly(WebEmail)
				.clickSubmit()
				.getErrorMessage();

		Assert.assertEquals(actualResultText, expectedConfirmationText, "Test Failed: Customer Service Webform Blank Message Box Error.");
	}
}
