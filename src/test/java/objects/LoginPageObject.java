package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageObject extends PageObjectSuperClass {
	
	@FindBy(id="email")
	private WebElement EmailInput;
	
	@FindBy(id="passwd")
	private WebElement PasswordInput;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(css=".account")
	private WebElement customerName;
	
	@FindBy(css=".myaccount-link-list li")
	private WebElement accountLinkList;

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

	public MyAddressesPageObject clickMyAddressButton() {
		getMyAccountLink("My addresses").click();
		return new MyAddressesPageObject(driver);
	}
	
	private WebElement getMyAccountLink(String linkName) {
		return accountLinkList.findElement(By.xpath("//*[contains(text(),'" + linkName + "')]/ancestor::a"));
	}

}
