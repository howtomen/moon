package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.ContactUsPage;
import objects.ContactUsResultPage;
import objects.LoginPageObject;
import support.DriverManagerFactory;
import support.DriverType;


public class customerServiceWebForm{
	
	protected WebDriver driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
	protected ContactUsPage contactUspage = new ContactUsPage(driver);
	protected ContactUsResultPage contactUsResultpage = new ContactUsResultPage(driver);

	@Given("^the user is on the contact us page$")
	public void the_user_is_on_the_contact_us_page() {
		contactUspage.goToPage();
	}

	@When("^the user chooses a dropdown hedding$")
	public void the_user_chooses_a_dropdown_hedding() {
		contactUspage.chooseDropdownHedding(); 
	}

	@Then("^the user enters in required information$")
	public void the_user_enters_in_required_information()  {
		contactUspage.enterRequiredFormInfo().clickSubmit(); 
	}

	@Then("^the user should get form sent success$")
	public void the_user_should_get_form_sent_success() {
		String expectedConfirmationText = "Your message has been successfully sent to our team.";
		String actualResultText = contactUsResultpage.getText();

		Assert.assertEquals(actualResultText, expectedConfirmationText, "Could not successfully submit a Customer Service Webform.");	
		driver.quit();
	}
}
