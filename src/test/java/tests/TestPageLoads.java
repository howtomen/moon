package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.PageLoadsObject; 

public class TestPageLoads extends TestSuperClass {
	
	@Test
	public void test() {
		//arrange
		String expectedPopularText = "POPULAR";
		
		//act
		String actualPopularText = new PageLoadsObject(driver)
				.goToPage()
				.returnText();
		
		//assert
		Assert.assertEquals(actualPopularText, expectedPopularText, "If no match, page loaded incorrectly!");
	}
}
