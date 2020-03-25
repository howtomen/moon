package objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartContentPage extends PageObjectSuperClass{

	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
	WebElement shoppingCart;
	
	public CartContentPage(WebDriver driverInstance) {
		super(driverInstance);
	}
	public CartContentPage goToPage() {
		navigate();
		return this;
	}

	public CartContentPage clickCartIcon() {
		shoppingCart.click();
		return this;
	}
	public String verifyCartPage() {
		
		WebElement cartTitle = driver.findElement(By.id("cart_title"));
		return cartTitle.getText();
	}
	
	public String productCount() {
		return driver.findElement(By.xpath("//*[@id=\"summary_products_quantity\"]")).getText();
	}

}
