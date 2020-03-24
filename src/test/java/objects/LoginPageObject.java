package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageObject extends PageObjectSuperClass {
	
	@FindBy(id="email")
	WebElement EmailInput;
	
	@FindBy(id="passwd")
	WebElement PasswordInput;
	
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	@FindBy(css=".account")
	private WebElement customerName;

	public LoginPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public LoginPageObject goToPage() {
		navigate("?controller=authentication&back=my-account");
		return this;
	}

	public LoginPageObject enterLoginInfo(String Email, String Password) {
		EmailInput.sendKeys(Email);
		PasswordInput.sendKeys(Password);
		return this;
	}

	public LoginPageObject clickSignInButton() {
		signInButton.click();
		return this;
	}

	public String getSignedInText() {
		return customerName.getText();
	}

}
