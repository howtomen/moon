package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemRemovalFromHomeObject extends PageObjectSuperClass {

	@FindBy(xpath="//*[@title='Continue shopping']")
	WebElement continueShoppingButton;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement cart;
	
	protected Actions builder;
	
	public ItemRemovalFromHomeObject(WebDriver driverInstance) {
		super(driverInstance);
		builder = new Actions(driver);
	}

	public ItemRemovalFromHomeObject goToPage() {
		navigate();
		return this;
	}

	public ItemRemovalFromHomeObject addToCart(String item) {
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@class='product-name'][@title='" + item + "']/ancestor::div[@class='product-container']//a[@title='Add to cart']"));
		addToCartButton.click();
		continueShoppingButton.click();
		return this;
	}

	public ItemRemovalFromHomeObject confirmItemInCart(String item) {
		cart.findElement(By.xpath("./following-sibling::div//a[@title='" + item + "']"));
		return this;
	}

	public ItemRemovalFromHomeObject removeFromCart(String item) {
		builder.moveToElement(cart).perform();
		WebElement removeButton = driver.findElement(By.xpath("//a[@title='View my shopping cart']/following-sibling::div//a[@title='" + item + "']/following-sibling::span/a"));
		removeButton.click();
		try {
			waitToBeRemoved(item);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		return this;
	}

	public boolean confirmItemRemoved(String item) {
		try {
			cart.findElement(By.xpath("./following-sibling::div//a[@title='" + item + "']"));
			return false;
		} catch(NoSuchElementException ex) {
			long time = 10;
			TimeUnit unit = TimeUnit.SECONDS;
			driver.manage().timeouts().implicitlyWait(time, unit);
			return true;
		}
	}
	
	private void waitToBeRemoved(String item) throws InterruptedException {
		long time = 1;
		TimeUnit unit = TimeUnit.SECONDS;
		driver.manage().timeouts().implicitlyWait(time, unit);
		while(true) {
			try {
				cart.findElement(By.xpath("./following-sibling::div//a[@title='" + item + "']"));
				Thread.sleep(500);
				continue;
			} catch(NoSuchElementException ex) {
				return;
			}
		}
	}

}
