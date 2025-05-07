package Practice.Resources;

import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {
	
	
	public static ExtentReports getReportObject() {
	
	String path = System.getProperty("user.id")+"//results//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("TestResult");
	reporter.config().setReportName("Web Automation Report");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Bhavya Panduranga");
	return extent;
	
	}
	

}
