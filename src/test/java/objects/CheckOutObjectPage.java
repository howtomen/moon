package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutObjectPage extends PageObjectSuperClass {
	@FindBy(css=".standard-checkout")
	WebElement proceedToCheckOutButton;
	
	@FindBy(name="processAddress")
	WebElement confirmAddressButton;
	
	@FindBy(css=".fancybox-error")
	WebElement errorMessage;

	public CheckOutObjectPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public CheckOutObjectPage proceedcheckout() {
		proceedToCheckOutButton.click();
		confirmAddressButton.click();
		proceedToCheckOutButton.click();
		return this;
	}

	public String getmodeltext() {
		return errorMessage.getText();
	}

}
