package tests;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import support.DriverManagerFactory;
import support.DriverType;

public class TestSuperClass {
	
	protected WebDriver driver;
	protected ATUTestRecorder recorder;
	
	@BeforeTest
	public void beforeTest() throws ATUTestRecorderException {
		driver = DriverManagerFactory.getManager(DriverType.CHROME).getDriver();
		/* This is snippet for recording test. 
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder("D:\\ScriptVideos\\","TestVideo-"+dateFormat.format(date),false);
		recorder.start(); 
		*/ 
	}
	
	@AfterTest
	public void afterTest() throws ATUTestRecorderException {
		//driver.quit();
		// recorder.stop(); Enable when test want to be recorded. 
	}

}
