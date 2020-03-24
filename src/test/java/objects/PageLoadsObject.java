package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLoadsObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//*[@id=\"home-page-tabs\"]/li[1]/a")
	WebElement popularButton;

	public PageLoadsObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public PageLoadsObject goToPage() {
		navigate();
		return this;
	}

	public String returnText() {
		return popularButton.getText();
	}
}
