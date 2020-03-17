
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestManufactureCheckbox extends TestSuperClass {
	@Test
	public void confirmResultOfManufactureFilter() {
		// arrange
		boolean allResultsAsExpected = true;
		String[] expectedListResults = {"Faded Short Sleeve T-shirts", "Blouse", "Printed Dress", "Printed Dress", "Printed Summer Dress", "Printed Summer Dress", "Printed Chiffon Dress"};

		// act
		List<String> actualListResults = new CategoryWomanPage(driver)
				.goToPage()
				.clickManufacturerCheckBox()
//					.waitTillPageFinishLoading()
				.getListResults();

		// assert
		for(int i=0; i < expectedListResults.length; i++){
			if (!expectedListResults[i].equals(actualListResults.get(i))) {
				allResultsAsExpected = false;
			}
		}
		Assert.assertTrue(allResultsAsExpected, "Fashion Manufacturer Checkbox filter did not work");
	}
}
