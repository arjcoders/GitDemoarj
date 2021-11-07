package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	 public WebDriver driver;
	
	 By email = By.cssSelector("[id='user_email']");
	 By password = By.cssSelector("[id='user_password']");
	 By submit = By.cssSelector("[value = 'Log In']");
	 By forgotpass = By.cssSelector("[href*='password/new']");
	
	public Loginpage(WebDriver driver3)
	{
		this.driver= driver3;
	}
	
	

	public ForgotPassword forgtpass()
	{
		 driver.findElement(forgotpass).click();
		 return new ForgotPassword(driver); 
	}
	
	public WebElement getemail()
	 {
		 return driver.findElement(email);		
	 }
	 
	public WebElement getpassword()
	 {
		 return driver.findElement(password);
	 }
	 
	public WebElement hitsubmit()
	 {
		 return driver.findElement(submit);
	 }
	
}
