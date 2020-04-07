package objects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RandomProductPageObject extends PageObjectSuperClass {
	
	@FindBy(id="send_friend_button")
	private WebElement SendToFriendLink;
	
	@FindBy(id="friend_name")
	private WebElement FriendNameInput;
	
	@FindBy(id="friend_email")
	private WebElement FriendEmailInput;
	
	@FindBy(id="sendEmail")
	private WebElement SendButton;
	
	@FindBy(css=".fancybox-opened > div > div > div > p:nth-child(2)")
	private WebElement SentMessageSuccess;

	public RandomProductPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public RandomProductPageObject goToPage() {
		Random rn = new Random();
		int n = rn.nextInt(6) + 1;
		navigate("?id_product="+ n +"&controller=product");
		return this;
	}

	public RandomProductPageObject clickSendToFriendLink() {
		SendToFriendLink.click();
		return this;
	}

	public RandomProductPageObject enterInput(String name, String email) {
		FriendNameInput.sendKeys(name);
		FriendEmailInput.sendKeys(email);
		return this;
	}

	public RandomProductPageObject clickSend() {
		SendButton.click();
		return this;
	}

	public String getMessage() {
		return SentMessageSuccess.getText();
	}

}
