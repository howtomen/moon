package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.LoginPageObject;
import support.DriverManagerFactory;
import support.DriverType;


public class login{
	
	protected WebDriver driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
	protected LoginPageObject loginpage = new LoginPageObject(driver);
	
//	@Before()
	

	@Given("^the user is on the login page$")
	public void the_user_is_on_the_login_page() {
		loginpage.goToPage();
	}

	@When("^the user enters logon credentials (.*?) and (.*?)$")
	public void the_user_enters_logon_credentials_tomsmith_and_SuperSecretPassword(String userName, String userPassword) {
		loginpage.enterLoginInfo(userName, userPassword); 
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button()  {
		loginpage.clickSignInButton(); 
	}

	@Then("^the user should see a success message$")
	public void the_user_should_see_a_success_message() {
		String expectedMessage = "John Smith";
		String flashMessageText = loginpage.getSignedInText();

		Assert.assertEquals(flashMessageText, expectedMessage);	
		driver.quit();
	}
}
