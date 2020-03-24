package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath= "//*[@id=\"layered_price_slider\"]/a[1]")
	WebElement leftSliderHandle;
	
	@FindBy(xpath= "//*[@id=\"layered_price_slider\"]/a[2]")
	WebElement rightSliderHandle;
	
	@FindBy(xpath= "//*[@id=\"layered_price_range\"]")
	WebElement priceRange;
	
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

	public CategoryWomanPage adjustPriceSlider() {
		for (int i = 0; i < 5; i++) {
			leftSliderHandle.sendKeys(Keys.ARROW_RIGHT);
			rightSliderHandle.sendKeys(Keys.ARROW_LEFT);
		}
		return this;
	}

	public String verifyPriceSlider() {
		return priceRange.getText();
	}
	
	@FindBy(css="#center_column > ul > li:nth-child(1) a.quick-view-mobile")
	private WebElement FirstProductQuickView;
	
	@FindBy(css=".fancybox-wrap")
	private WebElement ModalBox;
	
	@FindBy(css=".fancybox-iframe")
	private WebElement productIframe;
	
	@FindBy(id="wishlist_button")
	private WebElement iframeWishListButton;
	
	@FindBy(css=".fancybox-close")
	private WebElement iframeclose;
	
	@FindBy(css="h1[itemprop='name']")
	private WebElement productName;

	public CategoryWomanPage clickOnFirstItem() {
		driver.manage().window().setSize(new Dimension(1024,768));
		FirstProductQuickView.click();
		return this;
	}

	public CategoryWomanPage addToWishList() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ModalBox));
		
		driver.switchTo().frame(productIframe);
		iframeWishListButton.click();
		return this;
	}

	public String getFirstItemandCloseModels() {
		String name = productName.getText();
		driver.switchTo().defaultContent();
		iframeclose.click();
		return name;
	}
	
	
}
