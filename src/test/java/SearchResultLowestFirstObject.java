import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResultLowestFirstObject extends PageObjectSuperClass {

	@FindBy(id="search_query_top")
	private WebElement searchTextField;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span")
	private WebElement lowestPriceItem;
	
	@FindBy(id="selectProductSort")
	private WebElement dropDown;
	
	public SearchResultLowestFirstObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public SearchResultLowestFirstObject goToPage() {
		navigate();
		return this;
	}

	public SearchResultLowestFirstObject enterSearchTextAndSubmit(String searchText) {
		searchTextField.sendKeys(searchText);
		searchButton.click();
		return this;
	}

	public String getFirstLowPriceElement() {
		
		System.out.println("getFirstLowPriceElement>" + lowestPriceItem.getText() + ".");
		return lowestPriceItem.getText();
	}
	
	public Select getDropdown() {
		Select sortDropdownList = new Select(dropDown);
		return sortDropdownList;
	}

	public SearchResultLowestFirstObject setDropdownList(String valueStr) {
		getDropdown().selectByVisibleText(valueStr);
		return this;
	}
	
}
