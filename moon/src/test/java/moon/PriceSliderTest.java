package moon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriceSliderTest extends TestSuperClass {
  @Test
  public void movePriceSlider() {
	  //arrange
	  String expectedValueRange = "$17.85 - $51.15";
	  
	  //act
	  String actualResult = new CategoryWomanPage(driver)
			  .goToPage()
			  .adjustPriceSlider()
			  .verifyPriceSlider();
	  
	  Assert.assertEquals(actualResult, expectedValueRange, "Could not move Slider");
  }
}
