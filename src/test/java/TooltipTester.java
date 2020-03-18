import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TooltipTester extends PageObjectSuperClass {
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	
	public TooltipTester(WebDriver driverInstance) {
		super(driverInstance);
	}
	
	public TooltipTester goToPage() {
		navigate();
		return this;
	}
	
	public void searchFor(String search) {
		searchField.sendKeys(search);
		searchField.sendKeys(Keys.ENTER);
	}
	
	public String[] getDescriptions() {
		List<WebElement> elements = driver.findElements(By.className("product-container"));
		int numElements = elements.size();
		String[] descriptions = new String[numElements];
		for(int i = 0; i < numElements; i++) {
			WebElement parentElement = elements.get(i);
			WebElement childElement = parentElement.findElement(By.className("product-name"));
			String elementText = childElement.getText().trim();
			descriptions[i] = elementText;
		}
		return descriptions;
	}
	
	public String[] getTooltips() {
		List<WebElement> elements = driver.findElements(By.className("product-container"));
		int numElements = elements.size();
		String[] tooltips = new String[numElements];
		for(int i = 0; i < numElements; i++) {
			WebElement parentElement = elements.get(i);
			WebElement childElement = parentElement.findElement(By.tagName("img"));
			String elementText = childElement.getAttribute("title");
			tooltips[i] = elementText;
		}
		return tooltips;
	}
}
