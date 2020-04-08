package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuantityLimitObject extends PageObjectSuperClass {
	
	@FindBy(xpath="//*[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;
	
	@FindBy(xpath="//td[@class='cart_quantity text-center']//input[@type='text']")
	WebElement quantityInput;
	
	@FindBy(xpath="//td[@class='cart_quantity text-center']//input[@type='hidden']")
	WebElement actualQuantity;
	
	public QuantityLimitObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public QuantityLimitObject goToPage() {
		navigate();
		return this;
	}

	public QuantityLimitObject addToCart(String item) {
		driver.findElement(By.xpath("//*[@class='product-name'][@title='" + item + "']/ancestor::div[@class='product-container']//a[@title='Add to cart']")).click();
		return this;
	}

	public QuantityLimitObject goToCart() {
		proceedToCheckoutButton.click();
		return this;
	}

	public QuantityLimitObject setQuantity(String quantity) throws InterruptedException {
		String value1 = actualQuantity.getAttribute("value");
		quantityInput.sendKeys(quantity);
		while(true) {
			String value2 = actualQuantity.getAttribute("value");
			if(value1.equals(value2)) {
				Thread.sleep(100);
			} else {
				return this;
			}
		}
	}

	public String getActualQuantity() {
		return actualQuantity.getAttribute("value");
	}

}
