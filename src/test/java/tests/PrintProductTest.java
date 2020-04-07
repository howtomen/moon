package tests;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.PageObjectSuperClass;

public class PrintProductTest extends TestSuperClass {
  @Test
  public void CanIPrintProduct() {
	  boolean PrintAlert = false;
	  String Tile1 = "//*[@id=\"homefeatured\"]/li[1]";
	  
	  new PageObjectSuperClass(driver)
	  .navigate();
	  driver.findElement(By.xpath(Tile1)).click();
	  String productWindowHandle = driver.getWindowHandle();
	  driver.findElement(By.xpath("//*[@id=\"usefull_link_block\"]/li[@class = 'print']/a")).click();
	  Set<String> windowHandles = driver.getWindowHandles();
	  if (!windowHandles.isEmpty()) {
	      driver.switchTo().window((String) windowHandles.toArray()[windowHandles.size() - 1]);
	      PrintAlert = true;
	  }

	  WebElement root = driver.findElement(By.tagName("print-preview-app"));
	  WebElement shadowRoot = expandRootElement(root);
	  
	  WebElement root2= shadowRoot.findElement(By.id("sidebar"));
	  WebElement shadowRoot2 = expandRootElement(root2);
	  
	  WebElement root3 = shadowRoot2.findElement(By.tagName("print-preview-button-strip"));
	  WebElement shadowRoot3 = expandRootElement(root3);
	  
	  shadowRoot3.findElement(By.className("cancel-button")).click();
	  
	  Assert.assertEquals(PrintAlert, true, "print alert was not found ");
	 
	  
  }
  
  public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor)driver)
	.executeScript("return arguments[0].shadowRoot", element);
		return ele;
	}

}

