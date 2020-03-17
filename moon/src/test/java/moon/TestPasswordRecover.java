package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPasswordRecover extends TestSuperClass {

	@Test
	public void test() {
		String actualConfirmationText = new PasswordRecoverObject(driver)
				.goToPage()
				.clickButton("login")
				.tryPassword()
				.clickButton("forgot")
				.inputEmail()
				.clickButton("retrieve")
				.getConfirmationText();
		
		String expectedConfirmationText = "A confirmation email has been sent to your address: test@test.com";
		
		Assert.assertEquals(actualConfirmationText, expectedConfirmationText, "Did not successfully retrieve email");
	}

}
