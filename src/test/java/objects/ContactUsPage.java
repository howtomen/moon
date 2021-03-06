package objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageObjectSuperClass {
	@FindBy(id="id_contact")
	WebElement dropdownList;
	
	@FindBy(id="email")
	WebElement emailInput;
	
	@FindBy(id="message")
	WebElement msgTextBox;
	
	@FindBy(id="submitMessage")
	WebElement sendButton;

	private String subHeading = "Customer service";
	private String email = "abcd@gmail.com";
	private String message = "This is a test message to check Customer Service Webform.";

	public ContactUsPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public ContactUsPage goToPage() {
		navigate("?controller=contact");
		return this;
	}

	public ContactUsPage chooseDropdownHedding() {
		getSelect(dropdownList).selectByVisibleText(subHeading);
		return this;
	}

	public ContactUsPage enterRequiredFormInfo() {
		emailInput.sendKeys(email);
		msgTextBox.sendKeys(message);
		return this;
	}

	public ContactUsResultPage clickSubmit() {
		sendButton.click();
		return new ContactUsResultPage(driver);
	}
	
	public ContactUsPage enterInfoNoEmail() {
		msgTextBox.sendKeys(message);
		return this;
	}

	public ContactUsPage enterEmailOnly(String webEmail) {
		emailInput.sendKeys(webEmail);
		return this;
	}

}
