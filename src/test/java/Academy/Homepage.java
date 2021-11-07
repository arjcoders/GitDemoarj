 package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.ForgotPassword;
import pageobjects.LandingPage;
import pageobjects.Loginpage;
import resources.Base;

public class Homepage extends Base {
	
	@Test(dataProvider = "getdata")
	public void basepagenavigation(String username, String password , String text) throws IOException
	{
		//we have beforetest annotation for this.
		
		driver = initializedriver();
		//we've been able to refer to initializedriver because we have extended and made it public there in the base class.
		//here we are not making any declaration about the object or the driver.
		
		driver.get(prop.getProperty("url"));
		
		//we have beforetest annotation for this.
		//there are two ways to use the class
		//either u use inheritance. second u create the object of the class.
		//here we are not hardcoding the login element as it can lead anychange in the future so we can edit in one place for our n number of testcases.
		
		LandingPage ld = new LandingPage(driver);
		
		//ld.getlogin().click();
		//Loginpage lg = new Loginpage(driver);
		
		//the click on thepage we have performed in the homepage itself n object creation also. so we are not initiating the object two times
		//bcz the we are landing on the two pages there so its lead to object optimisation.
		
		Loginpage lg = ld.getlogin();
		lg.getemail().sendKeys(username);
		lg.getpassword().sendKeys(password);
		System.out.println(text);
		lg.hitsubmit().click();
		
		ForgotPassword fp1 = lg.forgtpass();
		fp1.getemail().sendKeys("arjunsingh@gmail.com");
		fp1.getinstructions().click();
	}
	
		@DataProvider
		public Object getdata()
		{
			Object[][] data = new Object[2][3];
			data[0][0] = "nonrestricteduser@qa.com";
			data[0][1] = "12345";
			data[0][2] = "nonrestricteduser";
					
			data[1][0] = "restricteduser@qa.com";
			data[1][1] = "123456";
			data[1][2] = "restricteduser";
			return data;
		}
		
		//here we are providing the data to the test cases through the object array
		//which works under the testng dataprovider annotation,where we are providing the data on the array format.
		//the function basepage navigation expects the parameters of the data sets we are providing through the array.
		
		@AfterTest
		public void teardown()
		{
			driver.close();
			//this is for closing the driver after the test execution is complete.
		}
	} 