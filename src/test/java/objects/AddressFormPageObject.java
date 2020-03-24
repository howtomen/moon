package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressFormPageObject extends PageObjectSuperClass {
	
	@FindBy(id="address1")
	private WebElement Address1;
	
	@FindBy(id="city")
	private WebElement City;
	
	@FindBy(id="id_state")
	private WebElement StateDropdown;
	
	@FindBy(id="postcode")
	private WebElement ZipCode;
	
	@FindBy(id="phone")
	private WebElement PhoneNumber;
	
	@FindBy(id="alias")
	private WebElement AddressName;
	
	@FindBy(id="submitAddress")
	private WebElement SaveButton;

	public AddressFormPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public MyAddressesPageObject fillOutNewAddressFormAndSave(String[] expectedSignedInText) {
		
		Address1.sendKeys(expectedSignedInText[0]);
		City.sendKeys(expectedSignedInText[1]);
		getSelect(StateDropdown).selectByVisibleText(expectedSignedInText[2]);
		ZipCode.sendKeys(expectedSignedInText[3]);
		PhoneNumber.sendKeys(expectedSignedInText[4]);
		AddressName.clear();
		AddressName.sendKeys(expectedSignedInText[5]);
		SaveButton.click();
		return new MyAddressesPageObject(driver);
	}

}
