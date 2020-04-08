package objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ColorSwitchingObject extends PageObjectSuperClass {
	
	protected WebElement closeButton;
	
	@FindBy(id="bigpic")
	WebElement image;
	
	@FindBy(id="color_14")
	WebElement colorButtonBlue;
	
	public ColorSwitchingObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public ColorSwitchingObject goToPage() {
		navigate();
		return this;
	}

	public ColorSwitchingObject getDetails(String item) {
		WebElement container = driver.findElement(By.xpath("//div[@class='product-image-container']/a[@title='" + item + "']"));
		try {
			container.findElement(By.xpath("./following-sibling::div/a[@class='quick-view-mobile']")).click();
		} catch(NoSuchElementException ex) {
			container.findElement(By.xpath("./following-sibling::a[@class='quick-view']")).click();
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(100));
		closeButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Close']"))));
		return this;
	}

	public ColorSwitchingObject switchColors() throws PageException {
		driver.switchTo().frame(1);
		String imageSrc1 = image.getAttribute("src");
		colorButtonBlue.click();
		String imageSrc2 = image.getAttribute("src");
		if(imageSrc1.equals(imageSrc2)) {
			throw new PageException("Image not changed");
		}
		driver.switchTo().defaultContent();
		return this;
	}

	public void closeWindow() {
		closeButton.click();
	}
}
