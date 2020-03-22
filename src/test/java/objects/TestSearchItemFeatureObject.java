package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestSearchItemFeatureObject extends PageObjectSuperClass {
	
	String dressSearchText = new String("dress");
	
	@FindBy(id="search_query_top")
	WebElement searchField;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	WebElement dressDescriptionText;

	public TestSearchItemFeatureObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public TestSearchItemFeatureObject goToPage() {
		navigate();
		return this;
	}

	public TestSearchItemFeatureObject enterValidDressItemAndSubmit() {
		searchField.sendKeys(dressSearchText);
		searchButton.click();
		return this;
	}

	public String getFirstDressText() {
		return dressDescriptionText.getText();
	}

}
