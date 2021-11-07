package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import pageobjects.LandingPage;
import resources.Base;

public class titleValidation extends Base {
	public WebDriver driver;
	LandingPage ld ;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void basepageNavigation() throws IOException
	{
		driver = initializedriver();
		log.info("driver is initialized");
		
		//driver we are getting from the base class, it works fine we run on sequential manner 
		//but as both classes fetching the same driver, driver gets overridden by the other class which creates alot of confusion.
		//driver.get("http://qaclickacademy.com");
		
		driver.get(prop.getProperty("url"));
		log.info("landed on the main page");
		
		LandingPage ld = new LandingPage(driver);
		
		Assert.assertEquals(ld.gettitle().getText(), "FEATUREDCOURSES123");
		log.info("succesfully validated text messages");
		
		Assert.assertTrue(ld.getnavbar().isDisplayed());
		log.info("successfully validated navigation bar");
	}
	
	public void header()
	{
		Assert.assertEquals(ld.gettitle2().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
