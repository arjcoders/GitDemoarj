package stepDefinition;

import cucumber.api.java.en.And;

//when we dont have any mapping implementation to our step definition file 
//we can simply copy the steps from the eclipse by executing the runner class.
//this is useful when we dont have the plugin available in the certain companies.
//we can use one stepdefinition line for multiple gherkinline.

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageobjects.LandingPage;
import pageobjects.Loginpage;
import pageobjects.PortalHomepage;
import resources.Base;

import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefination extends Base {
	@Given("^initializing the browser with chrome$")
	public void initializing_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver = initializedriver();
		//u r getting this driver from the base class and are assigning to the pageobject file
		//after that u are assigning it to the local driver and performing the tasks.
	}

	@Given("^navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
		driver.get(arg1);
	}

	@Given("^click on Login link in homepage to land on secure sign in page$")
	public void click_on_Login_link_in_homepage_to_land_on_secure_sign_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
           LandingPage ld = new LandingPage(driver);
           if(ld.getpopupsize()>0)
           {
        	   ld.getpopup().click();
           }
           ld.getlogin();
	
	}

	@Then("^verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		PortalHomepage ph = new PortalHomepage(driver);
		Assert.assertTrue(ph.searchboxes().isDisplayed());
	}
	 @When("^user enters (.+) and (.+) and logs in$")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	        
		 Loginpage lg = new Loginpage(driver);
			lg.getemail().sendKeys(username);
			lg.getpassword().sendKeys(password);
			//System.out.println(text);
			lg.hitsubmit().click();
	    }
	
	 @And("^close the browsers$")
	    public void close_the_browsers() throws Throwable {
	      driver.quit();
	    }

}