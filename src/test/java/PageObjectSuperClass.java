
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageObjectSuperClass {
	
	protected WebDriver driver;
	protected String baseUrl = "http://automationpractice.com/index.php";
	
	public PageObjectSuperClass(WebDriver driverInstance) {
		driver = driverInstance;
		PageFactory.initElements(driver, this);
	}
	
	public void navigate() {
		driver.get(baseUrl);
	}
	
	public void navigate(String url) {
		driver.get(baseUrl + url);
	}
	
	protected Select getSelect(WebElement element) {
		return new Select(element);
	}
}
