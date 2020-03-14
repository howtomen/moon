package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCustomerServiceWebform extends TestSuperClass {

	// As an 'Online Shopper'
	// I want to 'Send a message to customer service'
	// So that 'I can complain about an order'
	@Test
	public void submitContactWebform() {
		// arrange
		String expectedConfirmationText = "Your message has been successfully sent to our team.";
		
		// act
		String actualResultText = new ContactUsPage(driver)
				.goToPage()
				.chooseDropdownHedding()
				.enterRequiredFormInfo()
				.clickSubmit()
				.getText();
		
		Assert.assertEquals(actualResultText, expectedConfirmationText, "Could not successfully submit a Customer Service Webform.");
	}
}
