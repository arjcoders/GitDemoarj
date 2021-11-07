package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
		//framework development is all about how better you maintain your testcase 
		//and data making it easier and quicker to change or alter some
		//issues on the demand of client.
	
		public WebDriver driver;
		public Properties prop;
		
		//framework best practice tells that to minimise the code length. 
		//here we created the global variable and initialized it for the whole class
		//so that we need not to write again and scope of this variable is throughout. 
		//in different case, it wouldhave been in ,to that particular loop.
		
		public WebDriver initializedriver() throws IOException
		{
			prop = new Properties();
		 
		 	//we are using properties file to externally make the browser listed and based on the command from testcase and call to that particular file
		 	//the required browser will get invoked.
		 	//we need to connect the properties file to the base class and this base class will be connected to all the testcases.
			
		 
		 	//system.getproperty("user.dir"); this tells us the path of current project in which we are working in.
		 
		 	//FileInputStream fis = new FileInputStream("C:\\Users\\manoj\\eclipse-workspace\\E2Eproject\\src\\main\\java\\resources\\data.properties");
		 	//we can avoid this hardcoding of the path through the above command , bcz the system can be different for the user,location can be different.
		 
		 	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			
			//load takes the information from fis about the file location.
			
			//String browserName = System.getProperty("browser");
			String browserName = "chrome";
			//this command will let the user to tweak the browser name accordng to their choice through the following maven command.
			//this command checks whether any value provided to the property browsername through the maven.
			//mvn test -Dbrowser = chrome
			//String browserName = prop.getProperty("browser")
			//headless mode is the execution when we execute the test cases without opening the browser, it runs with the binary.
			
			System.out.println(browserName);
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver =new ChromeDriver();
			}
			else if(browserName.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
			
			//this is the centralised way of synchronization and we are waiting 10 seconds before failing the scripts .
			//return is like we are returning the driver object in turn when someone calls the method.
		}
		
		public String getScreenshotPath(String testcasename,WebDriver driver) throws IOException
		{    
			//testcase name,driver instance  we will be getting from the listeners class.
			//both the testcasename and driver instance we will have to give to the result field of the listener method.
			//which will helps us in capturing the required failure testcase with driver setting for getting the particular screenshot.
		
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);	
			String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
			
			//reports is the name which we will get on refreshing the project and in it failed testcase screenshot will be present.
			//"user.dir" this gives the current project path.
			
			FileUtils.copyFile(source, new File(destinationfile));
			return destinationfile;
		
		}
	}