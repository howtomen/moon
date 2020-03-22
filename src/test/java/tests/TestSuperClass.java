package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import support.DriverManagerFactory;
import support.DriverType;

public class TestSuperClass {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
	}
	
	@AfterTest
	public void afterTest() {
		//driver.quit();
	}

}
