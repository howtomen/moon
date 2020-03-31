package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartContentPageTUQVP extends PageObjectSuperClass {
	public CartContentPageTUQVP(WebDriver driverInstance) {
		super(driverInstance);
	}

	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
	WebElement shoppingCart;
	
	public CartContentPageTUQVP goToPage() {
		navigate();
		return this;
	}

	public CartContentPageTUQVP clickCartIcon() {
		shoppingCart.click();
		return this;
	}
/*	
	public String verifyCartPage() {
		
		WebElement cartTitle = driver.findElement(By.id("cart_title"));
		return cartTitle.getText();
	}
	*/
/*	
	public String productCount() {
		return driver.findElement(By.xpath("//*[@id=\"summary_products_quantity\"]")).getText();
	}
*/
	public String totalPrice() {
		waitToTally();
		return driver.findElement(By.id("total_product_price_1_1_0")).getText();
	}

	private void waitToTally() {
		long time = 60;
		TimeUnit unit = TimeUnit.SECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
}