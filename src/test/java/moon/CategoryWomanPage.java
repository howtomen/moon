package moon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryWomanPage extends PageObjectSuperClass {
	@FindBy(id="layered_manufacturer_1")
	WebElement manufacturerCheckBox;
	
	@FindBy(css=".product_list p img")
	WebElement LoadingImg;
	
	public CategoryWomanPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public CategoryWomanPage goToPage() {
		navigate("?id_category=3&controller=category");
		return this;
	}
	public CategoryWomanPage clickManufacturerCheckBox() {
		boolean isChecked = manufacturerCheckBox.isSelected();
		if (isChecked == false) {
			manufacturerCheckBox.click();
		}
		return this;
	}
	
	public CategoryWomanPage waitTillPageFinishLoading() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(LoadingImg));
		return this;
	}

	public List<String> getListResults() {
		List<WebElement> ListWebelement = driver.findElements(By.cssSelector("#center_column ul li div div h5 a.product-name"));
		List<String> elementsText = new ArrayList<String>();
		
		for(int i=0; i<ListWebelement.size(); i++){
			elementsText.add(ListWebelement.get(i).getText());
	    }
		return elementsText;
	}
}
