import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BestSellers extends PageObjectSuperClass {
	
	@FindBy(className="blockbestsellers")
	WebElement bestSellersButton;
	
	public BestSellers(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public BestSellers goToPage() {
		navigate();
		return this;
	}
	
	public String bestSellers() {
		bestSellersButton.click();
		return bestSellersButton.getText();
	}

}
