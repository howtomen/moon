package objects;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import support.PageException;

public class ThumbnailPreviewObject extends PageObjectSuperClass {

	protected Wait<WebDriver> wait;

	protected WebElement previewButton;
	protected WebElement closeButton;
	protected WebElement bigpic;

	protected Actions builder;

	public ThumbnailPreviewObject(WebDriver driverInstance) {
		super(driverInstance);
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500));
		builder = new Actions(driver);
	}

	public ThumbnailPreviewObject goToPage() {
		navigate();
		return this;
	}

	public ThumbnailPreviewObject openPreview(String item) {
		previewButton = driver.findElement(By.xpath("//div[@class='product-image-container']/a[@title='" + item + "']/following-sibling::div[@class='quick-view-wrapper-mobile']/a"));
		previewButton.click();
		return this;
	}

	public ThumbnailPreviewObject waitForPopup() {
		closeButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@title='Close']"))));
		return this;
	}

	public ThumbnailPreviewObject hoverOverThumbnails() throws PageException {
		driver.switchTo().frame(1);
		bigpic = driver.findElement(By.xpath("//img[@id='bigpic']"));
		ArrayList<String> sources = new ArrayList<String>();
		List<WebElement> thumbnails = driver.findElements(By.xpath("//div[@id='thumbs_list']//li"));
		for(WebElement thumbnail:thumbnails) {
			builder.moveToElement(thumbnail).perform();
			String source = bigpic.getAttribute("src");
			for(String string:sources) {
				if(source.equals(string)) {
					throw new PageException("Duplicate src returned. Error in hoverOverThumbnails.");
				}
			}
			sources.add(source);
		}
		driver.switchTo().defaultContent();
		return this;
	}

	public ThumbnailPreviewObject closePreview() {
		closeButton.click();
		return this;
	}

}
