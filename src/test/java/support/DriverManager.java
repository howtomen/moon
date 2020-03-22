package support;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	protected abstract void startService();
	protected abstract void stopService();
	protected abstract void createDriver();
	
	//protected WebDriver getDriver() {
	public WebDriver getDriver() {
		createDriver();
		return driver;
	}
	
	
	//protected void quitDriver() {
	public void quitDriver() {
		driver.quit();
	}
}
