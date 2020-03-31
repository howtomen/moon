package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetEmailObject extends PageObjectSuperClass {

	@FindBy(className="login")
	private WebElement signInButton;
	
	@FindBy(xpath="//*[@id='login_form']/div/p[1]/a")
	WebElement forgotPasswordButton;
	
	@FindBy(xpath="//*[@id='form_forgotpassword']/fieldset/p/button")
	WebElement retrievePasswordButton;
	
	@FindBy(xpath="//*[@id='center_column']/div/p")
	WebElement emailConfirmationMessage;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div/p")
	WebElement alertText_1;

	@FindBy(xpath="//*[@id=\"center_column\"]/div/div/ol/li")
	WebElement alertText_2;

	private String nonExistentEmail = new String("rprs@rprs.rprs");
	
	public SetEmailObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public SetEmailObject goToPage() {
		navigate();
		signInButton.click();
		
		return this;
	}

	public SetEmailObject clickForgotPassword() {
		forgotPasswordButton.click();
		
		return this;
	}

	public SetEmailObject setPasswordAndRetrieve() {
		emailField.sendKeys(nonExistentEmail);
		retrievePasswordButton.click();
		
		return this;
	}

	public String[] getAlertText() {
		String[] alertTexts = new String[] {alertText_1.getText(), alertText_2.getText()};
		//String[] alertTexts = new String[] {"There is 1 error", "There is no account registered for this email address."};

		return alertTexts;
	}

}
