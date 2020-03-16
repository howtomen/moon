package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTooltip extends TestSuperClass {
	
	TooltipTester tester;
	
	@Test
	public void testTooltips() {
		tester = new TooltipTester(driver);
				
		tester
		.goToPage()
		.searchFor("dress");
		
		String[] descriptions = tester.getDescriptions();
		
		String[] tooltips = tester.getTooltips();
		
		for(int i = 0; i < descriptions.length; i++) {
			System.out.println("Tooltip: " + tooltips[i] + "\nDescription: " + descriptions[i] + "\n");
			Assert.assertEquals(descriptions[i], tooltips[i], "Tooltip does not match description");
		}
	}
}
