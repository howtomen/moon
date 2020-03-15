package moon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSuperClass {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
