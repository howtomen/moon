package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestSellersObject extends PageObjectSuperClass {
	
	@FindBy(className="blockbestsellers")
	WebElement bestSellersButton;
	
	public BestSellersObject(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public BestSellersObject goToPage() {
		navigate();
		return this;
	}
	
	public String bestSellers() {
		bestSellersButton.click();
		return bestSellersButton.getText();
	}

}
