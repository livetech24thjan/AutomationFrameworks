package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import pages.BasePage;

public class MyTestNGListener extends BaseTest  implements ITestListener  {

	
	public void onTestStart(ITestResult result) {
		
	}


	public void onTestSuccess(ITestResult result) {
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		BasePage.screenshot();
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		
	}

	
	
}
