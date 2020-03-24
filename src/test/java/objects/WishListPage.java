package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageObjectSuperClass {
	
	@FindBy(css="#block-history table")
	private WebElement MyWishListTable;
	
	@FindBy(css="#block-history")
	private WebElement MyWishListLink;
	
	@FindBy(css="#s_title")
	private WebElement FirstItemOnWishListTitle;

	@FindBy(css="#s_title > small")
	private WebElement TitleSmallTextNeedToRemove;
	
	public WishListPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public String getNameOfFirstItemOnListandRemove() {
		MyWishListLink.findElement(By.xpath("//a[contains(text(),'My wishlist')]")).click();
		
		String name = FirstItemOnWishListTitle.getText();
		String removeWord = TitleSmallTextNeedToRemove.getText();
		
		name = name.replaceAll(removeWord, "");
		name = name.replaceAll("\n", "");
				
		System.out.println("\n Name: " + name);
		return name;
	}

}
