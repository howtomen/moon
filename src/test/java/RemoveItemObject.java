import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class RemoveItemObject extends PageObjectSuperClass {

	@FindBy(xpath="//*[@class='product-name'][@title='Blouse']/ancestor::div[@class='product-container']//a[@title='Add to cart']")
	WebElement addToCartButtonBlouse;

	@FindBy(xpath="//*[@class='product-name'][@title='Printed Chiffon Dress']/ancestor::div[@class='product-container']//a[@title='Add to cart']")
	WebElement addToCartButtonChiffon;

	@FindBy(xpath="//*[@title='Continue shopping']")
	WebElement continueShoppingButton;

	@FindBy(xpath="//*[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	@FindBy(xpath="//*[@class='product-name']/a[text()='Blouse']/ancestor::tr/td[@class='cart_quantity text-center']//a[@title='Subtract']")
	WebElement removeFromCartButtonBlouse;

	public RemoveItemObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public RemoveItemObject goToPage() {
		navigate();
		return this;
	}

	public RemoveItemObject addItemsToCart() {
		addToCartButtonBlouse.click();
		continueShoppingButton.click();
		addToCartButtonChiffon.click();
		proceedToCheckoutButton.click();
		return this;
	}

	public RemoveItemObject confirmItemIsInCart() throws CartException {
		String[] itemsInCart = findItemsInCart();
		for(String item:itemsInCart) {
			if(item.equals("Blouse")) {
				return this;
			}
		}
		throw new CartException("Blouse not in cart");
	}

	public RemoveItemObject removeItemFromCart() {
		removeFromCartButtonBlouse.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(100));
		try {
			wait.until(ExpectedConditions.invisibilityOf(removeFromCartButtonBlouse));
		} catch(NoSuchElementException ex) {
			return this;
		}
		return this;
	}

	public boolean confirmItemIsRemoved() {
		String[] itemsInCart = findItemsInCart();
		for(String item:itemsInCart) {
			if(item.equals("Blouse")) {
				return false;
			}
		}
		return true;
	}

	private String[] findItemsInCart() {
		List<WebElement> items = driver.findElements(By.xpath("//*[@class='product-name']"));
		String[] itemsInCart = new String[items.size()];
		for(int i = 0; i < items.size(); i++) {
			itemsInCart[i] = items.get(i).getText();
		}
		return itemsInCart;
	}
}
