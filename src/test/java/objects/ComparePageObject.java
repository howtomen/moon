package objects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComparePageObject extends PageObjectSuperClass {

	public ComparePageObject(WebDriver driverInstance) {
		super(driverInstance);
	}

	public boolean verifyCompare() {
		try {
			driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody/tr[1]/td[2]/h5/a"));
			driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody/tr[1]/td[3]/h5/a"));	
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
