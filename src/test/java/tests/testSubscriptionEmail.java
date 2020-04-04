package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.PageObjectSuperClass;
import objects.SubscriptionPageObject;

public class testSubscriptionEmail extends TestSuperClass {
	@Test
	public void subscriptionEmail() {
		String expectedString = "Newsletter : You have successfully subscribed to this newsletter.";

		new PageObjectSuperClass(driver).navigate();

		String randomEmailGenerator = new SubscriptionPageObject(driver)
				.generateRandomEmail(10);

		String actualString = new SubscriptionPageObject(driver)
				.inputRandomEmail(randomEmailGenerator)
				.clickSubmit()
				.getmessage();
		
		Assert.assertEquals(actualString, expectedString, "Test to signup for NewsLetter Failed");
	}
}
