package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.PageObjectSuperClass;
import objects.TileObjectSuperClass;

public class QuickViewPriceTest extends TestSuperClass {
  @Test
  public void CheckQuickviewPrice() {
	  String Tile1 = "//*[@id=\"homefeatured\"]/li[1]";
	  new PageObjectSuperClass(driver)
	  .navigate();
	  
	  new TileObjectSuperClass(driver).quickView(Tile1);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
	  
	  String actual = driver.findElement(By.id("our_price_display")).getText();
	  Assert.assertEquals(actual, "$16.51", "price is not correct");
  }
}

