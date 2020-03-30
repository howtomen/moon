package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.ContactUsPage;

public class ContactNoEmailTest extends TestSuperClass {
  @Test
  public void CanIContactWithNoEmail() {
	  
	  new ContactUsPage(driver)
	  .goToPage()
	  .chooseDropdownHedding()
	  .enterInfoNoEmail()
	  .clickSubmit();
	  
	  String actual = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText();
	  Assert.assertEquals(actual, "Invalid email address.", "Error code wasn't found");
	  
  }
}
