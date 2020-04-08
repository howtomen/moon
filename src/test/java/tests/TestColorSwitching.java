package tests;

import org.testng.annotations.Test;
import objects.ColorSwitchingObject;
import objects.PageException;

public class TestColorSwitching extends TestSuperClass {

	@Test
	public void canSwitchColors() throws PageException {
		new ColorSwitchingObject(driver)
		.goToPage()
		.getDetails("Faded Short Sleeve T-shirts")
		.switchColors()
		.closeWindow();
	}

}
