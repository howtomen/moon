package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateYouTubeLinkObject extends PageObjectSuperClass {

	public ValidateYouTubeLinkObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public ValidateYouTubeLinkObject goToPage() {
		navigate("");
		
		return this;
	}

	public ValidateYouTubeLinkObject clickYouTube() {
		WebElement youTubeButton = driver.findElement(By.xpath("//*[@id=\"social_block\"]/ul/li[3]/a"));
		youTubeButton.click();
		
		return this;
	}

	public String getUrl() {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		return driver.getCurrentUrl().toString();
	}

}
