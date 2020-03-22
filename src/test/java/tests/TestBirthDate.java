package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.BirthDateDropdownPageObject;

public class TestBirthDate extends TestSuperClass {

	@Test
	public void testDay() {

		//arrange
		String expectedDayOutputObject[] = new String[2];
		expectedDayOutputObject[0] = "1";
		expectedDayOutputObject[1] = "31";
				
		//act
		String actualDayOutputObject[] = new String[2];
		for (int i = 0; i < expectedDayOutputObject.length; i++ ) {
			actualDayOutputObject[i] = new BirthDateDropdownPageObject(driver)
					.goToPage()
					.clickLoginButton()
					.enterValidEmailAndSubmit()
					.setDayDropdownList(expectedDayOutputObject[i])
					.getDayDropdownListValue();
			
			//System.out.println("actualDayOutputObject>" + actualDayOutputObject[i] + ".");
		}


		//assert
		//Fixed in DropdownPageObject()
		//expectedDayOutputObject[0] = "1  "; // redefined with space at the end
		//expectedDayOutputObject[1] = "31  "; // the assert fails unless two spaces are appended
		Assert.assertEquals(actualDayOutputObject, expectedDayOutputObject, "Day arrays do not match!");

	}


	@Test
	public void testMonth() {

		//arrange
		String expectedMonthOutputObject[] = new String[2];
//		expectedMonthOutputObject[0] = "January";
//		expectedMonthOutputObject[1] = "December";
		expectedMonthOutputObject[0] = "1";
		expectedMonthOutputObject[1] = "12";
				
		//act
		String actualMonthOutputObject[] = new String[2];
		for (int i = 0; i < expectedMonthOutputObject.length; i++ ) {
			actualMonthOutputObject[i] = new BirthDateDropdownPageObject(driver)
					.goToPage()
					.clickLoginButton()
					.enterValidEmailAndSubmit()
					.setMonthDropdownList(expectedMonthOutputObject[i])
					.getMonthDropdownListValue();
			
			//System.out.println("actualMonthOutputObject>" + actualMonthOutputObject[i] + ".");
		}

		//assert
		Assert.assertEquals(actualMonthOutputObject, expectedMonthOutputObject, "Day arrays do not match!");

	}

	
	@Test
	public void testYear() {

		//arrange
		String expectedYearOutputObject[] = new String[2];
		
		expectedYearOutputObject[0] = "2020";
		expectedYearOutputObject[1] = "1900";
				
		//act
		String actualYearOutputObject[] = new String[2];
		for (int i = 0; i < expectedYearOutputObject.length; i++ ) {
			actualYearOutputObject[i] = new BirthDateDropdownPageObject(driver)
					.goToPage()
					.clickLoginButton()
					.enterValidEmailAndSubmit()
					.setYearDropdownList(expectedYearOutputObject[i])
					.getYearDropdownListValue();
			
			//System.out.println("actualYearOutputObject>" + actualYearOutputObject[i] + ".");
		}

		//assert
		Assert.assertEquals(actualYearOutputObject, expectedYearOutputObject, "Day arrays do not match!");

	}	
		
}
