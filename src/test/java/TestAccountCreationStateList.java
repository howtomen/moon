
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAccountCreationStateList extends TestSuperClass {

	// As an 'Developer'
	// I want to 'Check if all the states are avaliable on the create accout dropdown list'
	// So that 'No user location will be excluded'
	@Test
	public void checkIfAllStateListed() {
		// arrange
		boolean allResultsAsExpected = true;
		ArrayList<String> missingStates = new ArrayList<String>();
		String[] expectedListResults = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","District of Columbia","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Puerto Rico","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","US Virgin Islands","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};

		// act
		ArrayList<String> actualListResults = new AccountCreationObject(driver)
				.goToPage()
				.clickButton("login")
				.enterValidEmailAndSubmit()
				.getStateListResults();

		// assert
		for(int i=0; i < expectedListResults.length; i++){
			if (actualListResults.indexOf(expectedListResults[i]) == -1) {
				missingStates.add(expectedListResults[i]);
//						System.out.println(expectedListResults[i]);
				allResultsAsExpected = false;
			}
		}
		Assert.assertTrue(allResultsAsExpected, "  Missing states from Dropdown List: \n \n" + missingStates + "\n \n");
	}
}
