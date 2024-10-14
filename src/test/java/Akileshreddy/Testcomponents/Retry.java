package Akileshreddy.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	//Below is the logic to rerun again the failed test you can run as many times as u can can 
	//by increasing number at maxTry.
	
	int count = 0;
	int maxTry = 1;
	@Override
	public boolean retry(ITestResult result) {
	if (count<maxTry) {
		
		count++;
		
		return true;
	}
		
		return false;
	}

	
	
	
}
