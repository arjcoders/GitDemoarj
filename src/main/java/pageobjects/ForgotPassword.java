package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public WebDriver driver;
	
	 private By email = By.cssSelector("[id='user_email']");
	 @SuppressWarnings("unused")
	private By submit = By.cssSelector("[value = 'Log In']");
	 private By forgotpass = By.cssSelector("[href*='password/new']");
	 private By sendmeins = By.cssSelector("[type = 'submit']");
	
	 //basic coding standard to make the variable private as it wont be good to make them accessible to the enduser.
	 //so we will hide them , and make them accessible through only the public methods.
	 //so right practice is , public methods and private variables.
	 //this is called encapsulation.
	 
	 //general question for framework , how did you achieve the encapsulation in your project.
	 
	public ForgotPassword(WebDriver driver3) {
		this.driver= driver3;
	}

	public WebElement forgtpass()
	{
		 return driver.findElement(forgotpass);
	}
	
	public WebElement getemail()
	 {
		 return driver.findElement(email);		
	 }
	 
	public WebElement getinstructions()
	 {
		 return driver.findElement(sendmeins);		
	 }
}
