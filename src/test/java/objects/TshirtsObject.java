package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TshirtsObject extends PageObjectSuperClass {

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tShirtsButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1/span[1]")
	WebElement tShirtsText; // can find it both ways
	
	//@FindBy(className="cat-name")
	//WebElement tShirtsText;

	public TshirtsObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public TshirtsObject goToPage() {
		navigate();
		return this;
	}

	public String tShirtsText() {
		tShirtsButton.click();
		return tShirtsText.getText();
	}
}
