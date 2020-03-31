package tests;

import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.AccountCreationObject;
import support.DatabaseSQLConnection;

public class TestAccountCreationStateList extends TestSuperClass {

	// As an 'Developer'
	// I want to 'Check if all the states are available on the create account dropdown list'
	// So that 'No user location will be excluded'
	@Test
	public void checkIfAllStateListed() throws Exception {
		// arrange
		boolean allResultsAsExpected = true;
		ArrayList<String> missingStates = new ArrayList<String>();
		ArrayList<String> expectedListResults = new DatabaseSQLConnection().canGetAllStates();
		
		// act
		ArrayList<String> actualListResults = new AccountCreationObject(driver)
				.goToPage()
				.clickButton("login")
				.enterValidEmailAndSubmit()
				.getStateListResults();

		// assert
		for(int i=0; i < expectedListResults.size(); i++){
			if (actualListResults.indexOf(expectedListResults.get(i)) == -1) {
				missingStates.add(expectedListResults.get(i));
				allResultsAsExpected = false;
			}
		}
		Assert.assertTrue(allResultsAsExpected, "\n \n  Missing states from Dropdown List: \n" + missingStates + "\n \n");
	}
}
