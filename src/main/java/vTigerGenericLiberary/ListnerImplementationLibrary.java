package vTigerGenericLiberary;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide the implementation to all the abstract methods in ITestListner
 * @author Rahim
 *
 */
public class ListnerImplementationLibrary implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) //run for every @Test starts
	{
        String MethodName = result.getMethod().getMethodName();
	    //Reporter.log("Test execution is started"+MethodName,true);
        test =report.createTest(MethodName); //Test script Exetution starts  in reports
        test.log(Status.INFO,"Test Execution sis started");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
	   // System.out.println("Test is successfull--->"+MethodName);	
		test.log(Status.PASS, MethodName+"--->pass");
	}

	public void onTestFailure(ITestResult result) 
	{
		WebdriverLibrary wLib =new WebdriverLibrary();
		JavaLiberary jLib =new JavaLiberary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//System.out.println("Test is failed--->"+MethodName);
		test.log(Status.FAIL, "Failed");
		test.log(Status.FAIL,result.getThrowable()) ;
		
		try {
			String path=wLib.TakeScreenShot(BaseClass.sDriver, MethodName);
			test.addScreenCaptureFromPath(path);
	        	} 
		catch (IOException e) 
		  {
			  // TODO Auto-generated catch block
			    e.printStackTrace();
		  }
	}

	   public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("Test is skiped --->"+MethodName);	
	    test.log(Status.SKIP, MethodName+"-->Skiped");
	    test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context)
	{
		Reporter.log("Execution od suite is Started",true);
		//Execution of suite starts here, hence configure the extent reports here
		ExtentSparkReporter htmlReport =new ExtentSparkReporter(".\\ExtendReports\\Report-"+new JavaLiberary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution reports for vTiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vTiger Execution reports");
		
		//
		ExtentReports report =new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment ","Testing");
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Reporter name ", "rahim");
	}

	public void onFinish(ITestContext context) {
		
		Reporter.log("Execution of suite finished",true);
		//Flush the reports-- here the execution is finished
		report.flush();
		
	}

	
	
}
