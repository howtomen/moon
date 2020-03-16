package moon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsResultPage extends PageObjectSuperClass {
	@FindBy(css=".alert.alert-success")
	private WebElement confirmationBox;

	public ContactUsResultPage(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public String getText() {
		return confirmationBox.getText();
	}
}
