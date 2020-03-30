package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TileObjectSuperClass extends PageObjectSuperClass {
	
	private WebElement Tile = null;
	
	public TileObjectSuperClass(WebDriver driverInstance) {
		super(driverInstance);

	}
	
	private WebElement hoverOverTile(String path) {
		Tile =  driver.findElement(By.xpath(path));
		Actions action = new Actions(driver);
		action.moveToElement(Tile).perform();
		return Tile;
	}

	public TileObjectSuperClass addToCart(String path) {
		Tile = hoverOverTile(path);
		String cartButtonPath = "/div/div[2]/div[2]/a[1]/span";
		Tile.findElement(By.xpath(path+cartButtonPath)).click(); 
		return this;
	}
	
	public TileObjectSuperClass quickView(String path) {
		Tile = hoverOverTile(path);
		String quickviewPath = "/div/div[1]/div/a[2]/span";
		Tile.findElement(By.xpath(path+quickviewPath)).click();
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
