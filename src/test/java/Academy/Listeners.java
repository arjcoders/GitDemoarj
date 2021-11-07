package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener{
//listeners implements the itestlistener interface as it will do through the methods defined in the itestng interface.
	//after configuring the methods we need to pass the listeners information to the testng.xml so that it gets control on encountering the issue.
	
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	//threadlocal is the class which provide the threadsafe execution of the object. here the object "test" is being used by multiple classes 
	//on parallel test execution so that leads to overriding of test object as the classes may not complete their execution in time and
	//which will lead test overriding by anyone of the classes. 
	//threadlocal need to know about the class of the obj test so as provide that information in the thread decalaration time .
	//extenttest which is the obj of the threadlocal will now keep the information of all test obj .
	//by sending all test objects to the threadlocal pool , now its the responsibility of the threadlocal to assign the right obj for
	//passing or failure of a particular test case.
	
	@Override
	public void onTestStart(ITestResult result) {
	
		ITestListener.super.onTestStart(result);
		 test = extent.createTest(result.getMethod().getMethodName());
		 
		 //this willthe get themethod name for which the entry is to be made in the reports.
		 
		 extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		extentTest.get().log(Status.PASS, "tests passed");
		//in parallel mode this variable is not threadsafe as it can get tied to the two scenarios at the same time.
		//thus causing ambiguity.
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
		extentTest.get().fail(result.getThrowable());
		
		//if we write any code here that code will get executed on testcase failure. similar for other methods also..
		
		WebDriver driver = null;
		
		//result is the field which has the knowledge about this method.
		
		ITestListener.super.onTestFailure(result);
		String testmethodname = result.getMethod().getMethodName();
		
	
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		//just like we have captured the methodname we need to capture the driver for that particular testcase.
		//as system need to know for which failed testcase driver does it need to take the screenshot.
		
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(testmethodname,driver), result.getMethod().getMethodName());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}

}
