package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.CartContentPage;

public class ViewCartContentTest extends TestSuperClass {
	//As an 'Online Shopper'
	// I want to be able to 'view my cart'
	// So that i can see what I am buying
	
	@Test
  public void viewCartContent() {
	  //arrange
	  String expectedConfirmation = "SHOPPING-CART SUMMARY";
	  
	 //act
	  String actualResult = new CartContentPage(driver)
			  .goToPage() //could be replaced by instance where we have a page already open. 
			  .clickCartIcon()
			  .verifyCartPage();
	  
	  Assert.assertEquals(actualResult, expectedConfirmation, "Could not View Cart");
			  
  }
}
