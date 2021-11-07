package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomepage {
	
	public WebDriver driver;
		
	By searchbox = By.name("query");
	
	public PortalHomepage(WebDriver driver3)
	{
		this.driver= driver3;
	}
	
	public WebElement searchboxes()
	{
		return driver.findElement(searchbox);		
	}
	 
}
