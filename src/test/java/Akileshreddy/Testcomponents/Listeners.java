package Akileshreddy.Testcomponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Akileshreddy.resources.ExtentReporterNG;

//public class Listeners implements ITestListener {

//	ExtentTest test;
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	
//	
//	@Override
//	public void onTestStart(ITestResult result) {
//		
//		test = extent.createTest(result.getMethod().getMethodName());
//	}	
//	
//	
//	@Override
//	public void onTestSuccess(ITestResult result) {
//	
//		test.log(Status.PASS, "Test Passed");
//	}
//	
//	
//	@Override
//	public void onTestFailure(ITestResult result) {
//	//test.log(Status.FAIL, "Test Failed"); here test will fail so we want to see where it 
//	//failed so mostly we don't use log in fail test case.
//		
//		//or
//		
//		test.fail(result.getThrowable());
//		
//		//How to take screenshot
//		
//	//test.addScreenCaptureFromPath(null, null)	
//		
//	}
//	
//	
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		
//			
//	}
//	
//	//@Override		
//	//public void onTestFinish(ITestResult result) {
//		
//			
//		
//	//}
//	
//	
//	
//	
//	
//	
//}
