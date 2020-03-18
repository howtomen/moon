import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchResultHighestFirstObject extends PageObjectSuperClass {

	@FindBy(id="search_query_top")
	private WebElement searchTextField;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span")
	private WebElement highestPriceItem;
	
	@FindBy(id="selectProductSort")
	private WebElement dropDown;
	
	public SearchResultHighestFirstObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public SearchResultHighestFirstObject goToPage() {
		navigate();
		return this;
	}

	public SearchResultHighestFirstObject enterSearchTextAndSubmit(String searchText) {
		searchTextField.sendKeys(searchText);
		searchButton.click();
		return this;
	}

	public String getFirstHighPriceElement() {
		
		System.out.println("getFirstHighPriceElement>" + highestPriceItem.getText() + ".");
		return highestPriceItem.getText();
	}
	
	public Select getDropdown() {
		Select sortDropdownList = new Select(dropDown);
		return sortDropdownList;
	}

	public SearchResultHighestFirstObject setDropdownList(String valueStr) {
		getDropdown().selectByVisibleText(valueStr);
		return this;
	}
	
}
