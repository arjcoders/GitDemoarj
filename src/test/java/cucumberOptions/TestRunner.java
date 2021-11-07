package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/java/features",//we can extend the path to the particular file name also if we need to.
		glue = "stepDefinition")
//cucumberoption is an annotation which takes two options features and glue which tell us about the 
//where is our feature file is placed n glue defines stepdefination file, in glue we dont give the path,just the package name.
public class TestRunner extends AbstractCucumberTestNGTests {

	
}


//when u update ur pom, u need to update the project also.