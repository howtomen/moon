package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageObjectSuperClass {
	
	@FindBy(css="#block-history table")
	private WebElement MyWishListTable;
	
	@FindBy(xpath="//*[@id=\"wishlist_16670\"]/td[1]/a")
	private WebElement MyWishListLink;
	
	@FindBy(css="#s_title")
	private WebElement FirstItemOnWishListTitle;

	@FindBy(css="#s_title > small")
	private WebElement TitleSmallTextNeedToRemove;
	
	public WishListPage(WebDriver driverInstance) {
		super(driverInstance);
	}

	public String getNameOfFirstItemOnListandRemove() {
		System.out.println("\n\n -- Wish List Element -- \n");
		MyWishListLink.click();
		
		String name = FirstItemOnWishListTitle.getText();
		String removeWord = TitleSmallTextNeedToRemove.getText();
		
		name = name.replaceAll(removeWord, "");
		name = name.replaceAll("\n", "");
				
		System.out.println("\n Name: " + name);
		return name;
	}

}
