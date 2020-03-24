package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import keys.devKey;
import objects.LoginPageObject;

public class TestCheckIfInvoiceDownloads extends TestSuperClass {

	// [PREREQUISIT: Must have ordered something from the site before]
	// As a 'Small Boutique that buys cheap dresses and sells at a higher price'
	// I want to 'Be able to get a copy of the invoice anytime'
	// So that 'anyone in my staff can see what has been purchased at this store online'
	@Test
	public void CheckInvoiceDL() throws Exception {
		String downloadLocation = new devKey().getdownloadLocation();
		String WebEmail = new devKey().getValidWebEmail();
		String WebPassword = new devKey().getValidWebPassword();
		
		String expectedFileName = new devKey().getInvoiceFileName();
		
		String actualFileName = new LoginPageObject(driver)
				.goToPage()
				.enterLoginInfo(WebEmail, WebPassword)
				.clickSignInButton()
				.clickOrderHistoryAndDetails()
				.clickDownloadPDF()
				.waitTillDownloaded(downloadLocation)
				.getnameofPDFDownloaded();
		
		Assert.assertEquals(actualFileName, expectedFileName, "Failed to add item to favorites");
	}
}
