import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchResultsByPrice extends TestSuperClass {

	@Test
	public void testPriceLowestFirst() {
		
		//arrange
		String searchText = new String("Dress");
		String valueStr = new String("Price: Lowest first");
		String expectedFirstLowPrice = new String("$16.51");
		
		//act
		String actualFirstLowPrice = new SearchResultLowestFirstObject(driver)
				.goToPage()
				.enterSearchTextAndSubmit(searchText)
				.setDropdownList(valueStr)
				.getFirstLowPriceElement();
		
		//assert
		Assert.assertEquals(actualFirstLowPrice, expectedFirstLowPrice, "Low Prices Do Not Match!");
	}


	@Test
	public void testPriceHighestFirst() {
		
		//arrange
		String searchText = new String("Dress");
		String valueStr = new String("Price: Highest first");
		String expectedFirstHighPrice = new String("$50.99");
		
		//act
		String actualFirstHighPrice = new SearchResultHighestFirstObject(driver)
				.goToPage()
				.enterSearchTextAndSubmit(searchText)
				.setDropdownList(valueStr)
				.getFirstHighPriceElement();
		
		//assert
		Assert.assertEquals(actualFirstHighPrice, expectedFirstHighPrice, "High Prices Do Not Match!");
	}
}
