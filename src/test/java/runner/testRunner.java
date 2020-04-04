package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\java\\features", 
glue=("stepDefinition"),
strict = true,  // if any steps does not have a method, even if the test ran perfectly, it will fail
dryRun = false) // set to true if you just wat to check the mapping and not run the methods 
public class testRunner {

}
