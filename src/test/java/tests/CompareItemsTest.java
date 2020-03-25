package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.CategoryWomanPage;

public class CompareItemsTest extends TestSuperClass{
  @Test
  public void CanICompareItems() {
	  
	  boolean expected = true;
	  
	  boolean actual = new CategoryWomanPage(driver)
			  .goToPage()
			  .windowResize()
			  .selectItemsToCompare();
	  Assert.assertEquals(actual, expected,"Compare Failed");
			  
  }
}
