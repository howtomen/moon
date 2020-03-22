package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.TestSearchItemFeatureObject;

public class TestSearchItemFeature extends TestSuperClass {
	
	@Test
	public void test() {
		
		//arrange
		String expectedDressText = "Printed Summer Dress";
		
		//act
		String actualDressText = new TestSearchItemFeatureObject(driver)
				.goToPage()
				.enterValidDressItemAndSubmit()
				.getFirstDressText();
		
		//assert
		Assert.assertEquals(actualDressText, expectedDressText, "You have not reached the dresses display page!");
	}
}
