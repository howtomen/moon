package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.ValidateYouTubeLinkObject;

public class TestSocialMediaLink extends TestSuperClass {
	
	@Test
	public void validateYouTubeLink() {
		
		//arrange
		String expectedUrl = new String("https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA");
		
		//act
		String actualUrl = new ValidateYouTubeLinkObject(driver)
				.goToPage()
				.clickYouTube()
				.getUrl();
		
		//assert
		//System.out.println("actualUrl = " + actualUrl);
		//System.out.println("expectedUrl = " + expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match! Error.");
	}
}
