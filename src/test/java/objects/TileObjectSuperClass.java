package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TileObjectSuperClass extends PageObjectSuperClass {
	
	public TileObjectSuperClass(WebDriver driverInstance) {
		super(driverInstance);

	}

	public TileObjectSuperClass addToCart(String path) {
		 WebElement Tile =  driver.findElement(By.xpath(path));
		 String buttonPath = "/div/div[2]/div[2]/a[1]/span";
		 Actions action = new Actions(driver);
		 action.moveToElement(Tile).perform();
		
		 Tile.findElement(By.xpath(path+buttonPath)).click();
		 
		 
		 return this;
	}
	
	public TileObjectSuperClass continueShopping() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
		return this;
	}
	
	public TileObjectSuperClass checkout() {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();
		return this;
	}
}
