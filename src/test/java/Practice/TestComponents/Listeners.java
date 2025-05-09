package Practice.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Practice.Resources.ExtentReporterNg;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test ;
	ExtentReports extent=ExtentReporterNg.getReportObject();
	@Override
	public void onTestStart(ITestResult result)
	{
	test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
	test.log(Status.PASS, "Test is passed");
	
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		String path = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			path = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
		
		
		
	}
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	
	
	

}
