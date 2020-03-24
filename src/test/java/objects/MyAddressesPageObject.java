package objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressesPageObject extends PageObjectSuperClass {
	
	@FindBy(css="a[title='Add an address']")
	private WebElement AddNewAddressButton;
	
//	@FindBy(css=".bloc_adresses:last-child .address:last-child ")
//	private List<WebElement> LastAddressBox;
	
	@FindBy(css=".last_item")
	private WebElement LastAddressBox;

	public MyAddressesPageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public AddressFormPageObject clickAddNewAddressButton() {
		AddNewAddressButton.click();
		return new AddressFormPageObject(driver);
	}

	public String[] ConfirmAddressAndDelete() {
		String address1 = LastAddressBox.findElement(By.cssSelector(".address_address1")).getText();
		String city = LastAddressBox.findElement(By.cssSelector("li:nth-child(5) > span:nth-child(1)")).getText();
		city = city.substring(0, city.length() - 1);
		String state = LastAddressBox.findElement(By.cssSelector("li:nth-child(5) > span:nth-child(2)")).getText();
		String zipcode = LastAddressBox.findElement(By.cssSelector("li:nth-child(5) > span:nth-child(3)")).getText();
		String phone = LastAddressBox.findElement(By.cssSelector(".address_phone")).getText();
		String title = LastAddressBox.findElement(By.cssSelector(".page-subheading")).getText();
		
		String[] result = {address1, city, state, zipcode, phone, title};
		LastAddressBox.findElement(By.cssSelector("a[title='Delete']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return result;
	}

}
