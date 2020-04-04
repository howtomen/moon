package objects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriptionPageObject extends PageObjectSuperClass {
	
	@FindBy(id="newsletter-input")
	private WebElement EmailSubscriptionInput;
	
	@FindBy(name="submitNewsletter")
	private WebElement EmailSubscriptionSubmit;
	
	@FindBy(css=".alert")
	private WebElement AlertMessage;

	public SubscriptionPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public String generateRandomEmail(int length) {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println("\n\nSALT STRING: " + saltStr+ "\n\n");
        return saltStr + "5@randomizedemail.com";
	}

	public SubscriptionPageObject inputRandomEmail(String email) {
		EmailSubscriptionInput.sendKeys(email);
		return this;
	}

	public SubscriptionPageObject clickSubmit() {
		EmailSubscriptionSubmit.click();
		return this;
	}

	public String getmessage() {
		return AlertMessage.getText();
	}

}
