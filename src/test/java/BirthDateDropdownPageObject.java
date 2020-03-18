import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BirthDateDropdownPageObject extends PageObjectSuperClass {

	private String email;
	private Random rand;

	@FindBy(className="login")
	private WebElement loginButton;

	@FindBy(id="email_create")
	private WebElement createAccountEmailField;

	@FindBy(id="SubmitCreate")
	private WebElement createAccountButton;

	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/h3")
	private WebElement personalInformationText;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;

	public BirthDateDropdownPageObject(WebDriver driverInstance) {
		super(driverInstance);
		rand  = new Random();
	}

	public BirthDateDropdownPageObject goToPage() {
		navigate();
		return this;
	}

	public BirthDateDropdownPageObject clickLoginButton() {
		loginButton.click();
		return this;
	}

	public BirthDateDropdownPageObject enterValidEmailAndSubmit() {
		while(true) {
			generateEmail();
			createAccountEmailField.sendKeys(email);
			createAccountButton.click();
			if (personalInformationText.getText().equals("YOUR PERSONAL INFORMATION")) {
				return this;
			}
		}
	}

	private void generateEmail() {
		int randomNumber = rand.nextInt(89999) + 10000;
		String randomEmailNumber = Integer.toString(randomNumber);
		email = randomEmailNumber + "@gmail.com";
	}

	public BirthDateDropdownPageObject setDayDropdownList(String dayStr) {
		
		Select dayBox = new Select(days);
		dayBox.selectByValue(dayStr);
		
		return this;
	}

	public String getDayDropdownListValue() {
		String tempStr = getDropdownDays().getFirstSelectedOption().getText();
		tempStr = tempStr.substring(0, tempStr.length() - 2);
		//System.out.println("getDayDropdownListValue>" + tempStr + ".");
		return tempStr;
	}
	
	public Select getDropdownDays() {
		Select dayDropdownList = new Select(days);
		return dayDropdownList;
	}

	public BirthDateDropdownPageObject setMonthDropdownList(String monthNumberStr) {
		Select monthBox = new Select(months);
		monthBox.selectByValue(monthNumberStr);
		
		return this;
	}

	public String getMonthDropdownListValue() {
		String tempStr = getDropdownMonths().getFirstSelectedOption().getText();
		
		tempStr = tempStr.substring(0, tempStr.length() - 1);
		
		//System.out.println("getMonthDropdownListValue>" + tempStr + ".");
				
		if (tempStr.equals("January"))
			tempStr = "1";
		else
			tempStr = "12";

		
		//System.out.println("getMonthDropdownListValue>" + tempStr + ".");

		return tempStr;
	}

	private Select getDropdownMonths() {
		Select monthDropdownList = new Select(months);
		return monthDropdownList;
	}
	
	public BirthDateDropdownPageObject setYearDropdownList(String yearStr) {
		
		Select yearBox = new Select(years);
		yearBox.selectByValue(yearStr);
		
		return this;
	}

	public String getYearDropdownListValue() {
		String tempStr = getDropdownYears().getFirstSelectedOption().getText();
		tempStr = tempStr.substring(0, tempStr.length() - 2);
		//System.out.println("getYearDropdownListValue>" + tempStr + ".");
		return tempStr;
	}
	
	public Select getDropdownYears() {
		Select yearDropdownList = new Select(years);
		return yearDropdownList;
	}

}
