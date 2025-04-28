package com.Mycard.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsListenerClass implements ITestListener 
{
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() 
	{
		
		String TimeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname = "MycardTestReport-"+TimeStamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+reportname);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// Add System Information / environment info to Reports
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "Window 11");
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("user Name", "Ram");
		
		// configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	// When Each Test case is get Started . this method is called
    public void onTestStart(ITestResult result) 
	  {
	       System.out.println(" Name of Test Start : "+result.getName());
	  }

    // When Test Case get Passed. this Method is Called
	 public void onTestSuccess(ITestResult result) 
	   {
	        System.out.println(" Name of Test Successfully Executed : "+result.getName());
	        test = reports.createTest(result.getName());
	        test.log(Status.PASS, MarkupHelper.createLabel(" Name Pass Test Case is : "+result.getName(), ExtentColor.GREEN));
	   }

	// When Test Case get Failed. this Method is Called
	 public void onTestFailure(ITestResult result) 
	    {
	              System.out.println(" Name of Test Failed : "+result.getName());
	              test= reports.createTest(result.getName());
	              test.log(Status.FAIL, MarkupHelper.createLabel(" Name Failed Test Case is : "+result.getName(), ExtentColor.RED ));
	              
	            String screenshotpath = System.getProperty("user.dir")+ "\\ScreenShots\\" +result.getName() + ".png";
	            
	            File screenshotfile = new File(screenshotpath);
	            
	            if(screenshotfile.exists()) 
	            {
	            	test.fail("Capured ScreenShot is Below : " + test.addScreenCaptureFromPath(screenshotpath));
	            }
	            
	    }

	// When Test Case get Skipped. this Method is Called
	  public void onTestSkipped(ITestResult result) 
	   {
	          System.out.println(" Name of Test Skipped : "+result.getName());
	          test = reports.createTest(result.getName());
	          test.log(Status.SKIP, MarkupHelper.createLabel(" Name Skip Test Case is : "+result.getName(), ExtentColor.YELLOW));
	   }

	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	   {
	            
	   }
	 
	// When Test Case get Failed With TimeOut. this Method is Called
	 public void onTestFailedWithTimeout(ITestResult result) 
	  {
	         onTestFailure(result);
	  }

	 // it called once at start before Test class Execution
	 public void onStart(ITestContext context) 
	   {
		   configureReport();
	       System.out.println(" Name of Start Test Case : "+context.getName());
	   }

	 // it calls when Test Class Methods Executed
	 public void onFinish(ITestContext context) 
	   {
		 System.out.println(" Name of Finish Test Case : "+context.getName());
		 reports.flush();
	   }
	 
}



