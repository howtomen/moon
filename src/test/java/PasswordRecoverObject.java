import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordRecoverObject extends PageObjectSuperClass {
	
	@FindBy(className="login")
	WebElement loginButton;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="passwd")
	WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement errorMessage;
	
	@FindBy(xpath="//*[@id='login_form']/div/p[1]/a")
	WebElement forgotPasswordButton;
	
	@FindBy(xpath="//*[@id='form_forgotpassword']/fieldset/p/button")
	WebElement retrievePasswordButton;
	
	@FindBy(xpath="//*[@id='center_column']/div/p")
	WebElement emailConfirmationMessage;
	
	public PasswordRecoverObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public PasswordRecoverObject goToPage() {
		navigate();
		return this;
	}

	public PasswordRecoverObject clickButton(String button) {
		switch(button) {
		case "login":
			loginButton.click();
			break;
		case "signin":
			submitButton.click();
			break;
		case "forgot":
			forgotPasswordButton.click();
			break;
		case "retrieve":
			retrievePasswordButton.click();
			break;
		default:
			System.out.println(button + " is not a recognized button");
		}
		return this;
	}

	public PasswordRecoverObject tryPassword() {
		emailField.sendKeys("test@test.com");
		passwordField.sendKeys("test");
		submitButton.click();
		if(errorMessage.getText().contentEquals("Invalid password.")) {
			return this;
		} else {
			System.out.println("Did not read Invalid Password");
			return null;
		}
	}

	public PasswordRecoverObject inputEmail() {
		emailField.sendKeys("test@test.com");
		return this;
	}

	public String getConfirmationText() {
		return emailConfirmationMessage.getText();
	}

}
