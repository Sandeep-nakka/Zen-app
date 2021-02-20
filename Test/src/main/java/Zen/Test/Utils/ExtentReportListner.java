package Zen.Test.Utils;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Zen.Test.Base.BasePage;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.util.Arrays;

public class ExtentReportListner extends BasePage implements ITestListener{
	ExtentTest test;
	ExtentReports reports=ExtentReport.ExtentreportGenerator();
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
		test.log(Status.INFO, "Executing: "+result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {
		String excepionMessage= Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occurred:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		Object testObject=result.getInstance();
		Class getdriver=result.getTestClass().getRealClass();
		try{
		driver=(WebDriver)getdriver.getDeclaredField("driver").get(testObject);
		}
		catch(Exception e){

		}

		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		if (reports != null) {

			reports.flush();
		}

	}
	

}