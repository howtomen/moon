package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.CartContentPage;
import objects.PageObjectSuperClass;
import objects.TileObjectSuperClass;

public class MultpleItemsTest extends TestSuperClass {
  @Test
  public void CanIAddMultipleItems() {

	  String Tile1 = "//*[@id=\"homefeatured\"]/li[1]";
	  String Tile2 = "//*[@id=\"homefeatured\"]/li[2]";
	  
	  new PageObjectSuperClass(driver)
	  .navigate();
	  
	  new TileObjectSuperClass(driver).addToCart(Tile1).continueShopping();
	  
	  WebDriverWait wait = new WebDriverWait(driver,5);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Tile2)));
	  
	  new TileObjectSuperClass(driver).addToCart(Tile2).checkout();
	  
	  String result = new CartContentPage(driver).productCount();
	  
	  Assert.assertEquals(result, "2 Products");
	  
  }
}
