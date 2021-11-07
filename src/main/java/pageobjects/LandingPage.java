package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title =  By.cssSelector("#content > div > div > h2");
	private By navbar = By.cssSelector("#content > div > div > h2");
	private By title2 = By.cssSelector("div[class*='video-banner'] h3");
	private By popup =  By.xpath("//button[text()='NO THANKS']");
	 
	 public LandingPage(WebDriver driver2)
	 {
		 this.driver= driver2;
	 }

	public Loginpage getlogin()
	{
		 //return driver.findElement(signin);
		 //here we returning the webelement so the return type is webelement.
		 //here we need to know which driver is used.this driver doesnot have any knowledge what n how to invoke.
		
		 driver.findElement(signin).click();
		Loginpage lg = new Loginpage(driver);
		return lg;
		 
		 //in this code we are landing on the page n then clicking on the login button.so in the homepage we created 2 objects
		 //so for that we create the statement ,we refer to the login page hereitself by creating the object of that page. 	
	}

	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	 
	public WebElement getnavbar()
	{
		return driver.findElement(navbar);
	}
	
	public WebElement gettitle2()
	{
		return driver.findElement(title2);
	}
	public int getpopupsize()
	{
		return driver.findElements(popup).size();	
	}
	
	public WebElement getpopup()
	{
		return driver.findElement(popup);
	}
}
