import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBestSellers extends TestSuperClass {

	@Test
	public void test() {
		
		String expectedText = "BEST SELLERS";
		
		String actualText = new BestSellers(driver)
				.goToPage()
				.bestSellers();
		
		Assert.assertEquals(actualText, expectedText, "Wrong Text");
		
	}
	
}
