package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objects.CartContentPage;
import objects.PageObjectSuperClass;


public class CheckOutEmptyCartTest extends TestSuperClass{
  @Test
  public void CanICheckoutEmptyCart() {
	  new PageObjectSuperClass(driver).navigate();
	  new CartContentPage(driver).clickCartIcon();
	  
	  String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
	  Assert.assertEquals(actual, "Your shopping cart is empty.", "Error was not found");
  }
}
