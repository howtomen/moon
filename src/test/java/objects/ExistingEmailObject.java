package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExistingEmailObject extends PageObjectSuperClass {
	
	@FindBy(className="login")
	private WebElement signInButton;

	private String usedEmail = new String("sample@sample.com");

	@FindBy(id="email_create")
	private WebElement createAccountEmailField;
	
	@FindBy(id="SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(xpath="//*[@id=\"create_account_error\"]//li")
	private WebElement errorText;

	public ExistingEmailObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public ExistingEmailObject goToPage() {
		navigate();
		
		return this;
	}

	public ExistingEmailObject clickSignIn() {
		signInButton.click();
		
		return this;
	}

	public ExistingEmailObject enterUsedEmailAndSubmit() {
		createAccountEmailField.sendKeys(usedEmail);
		createAccountButton.click();
		
		return this;
	}

	public String getAlertText() {
		
		return errorText.getText();
		//return "An account using this email address has already been registered. Please enter a valid password or request a new one.";
	}

}
