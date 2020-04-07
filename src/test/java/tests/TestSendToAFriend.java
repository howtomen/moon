package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.RandomProductPageObject;

public class TestSendToAFriend extends TestSuperClass {
  @Test
  public void SendToAFriend() {
	  String expectedText = "Your e-mail has been sent successfully";
	  
	  String actualText = new RandomProductPageObject(driver)
			  .goToPage()
			  .clickSendToFriendLink()
			  .enterInput("Random Friend", "random_friend@testrandom.com")
			  .clickSend()
			  .getMessage();
	  
	  Assert.assertEquals(actualText, expectedText, "Test Send Product to friend failed.");
  }
}
