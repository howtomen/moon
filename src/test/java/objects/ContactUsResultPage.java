package objects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsResultPage extends PageObjectSuperClass {
	@FindBy(css=".alert.alert-success")
	private WebElement confirmationBox;
	
	@FindBy(css=".alert ol li")
	private WebElement errorBox;

	public ContactUsResultPage(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public String getText() {
		return confirmationBox.getText();
	}

	public String getErrorMessage() {
		return errorBox.getText();
	}
}
