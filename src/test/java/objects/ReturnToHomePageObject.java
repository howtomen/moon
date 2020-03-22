package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReturnToHomePageObject extends PageObjectSuperClass {

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tShirtsButton;

	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement yourLogoButton;
	
	@FindBy(xpath="//*[@id=\"home-page-tabs\"]/li[1]/a")
	WebElement popularButton;
	
	public ReturnToHomePageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public ReturnToHomePageObject goToPage() {
		navigate();
		return this;
	}

	public ReturnToHomePageObject clickTshirts() {
		tShirtsButton.click();
		return this;
	}

	public ReturnToHomePageObject clickYourLogo() {
		yourLogoButton.click();
		return this;
	}

	public String returnText() {
		return popularButton.getText();
	}

}
