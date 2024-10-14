package Akileshreddy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Akileshreddy.Testcomponents.Basetest;

public class SubmitOrderTest extends Basetest {
//This the copypaste of standalone Test class....Do not confuse
// This is an ecommerce project will be usefull as an example in realtime...Keep it for Reference

	
	String itemName = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData", groups = "AkileshOrder")
	public void submitOrder(HashMap<String, String> input) throws IOException {
		// TODO Auto-generated method stub
		

		Productcatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> items = productCatalogue.getItemsList();
		productCatalogue.addProductToCart(input.get("item"));
		Cartpage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductsDisplay(input.get("item"));
		Assert.assertTrue(match);
		Checkout checkout = cartPage.goToCheckout();
		checkout.selectCountry("india");
		Confirmationpage confirmationPage = checkout.submitOrder();
		String confirmmEssage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmmEssage.equalsIgnoreCase("Thankyou for the order."));
	
	}
	
@Test(dependsOnMethods = {"submitOrder"})
public void orderHistoryTest() {
	
	Productcatalogue productCatalogue = landingPage.loginApplication("akileshnikki@outlook.com", "Akilesh@123");
	Orderpage orderPge = productCatalogue.goToOrderPage();
	Assert.assertTrue(orderPge.verifyOrderDisplay(itemName));
	
}

//How to take screenshot below.

//public void getScreenshot() throws IOException {
//	TakesScreenshot ts = (TakesScreenshot)driver;
//	File source = ts.getScreenshotAs(OutputType.FILE);
//	File file = new File();
//	FileUtils.copyFile(source, "//Users//User//OneDrive//Documents");
//}



//We can drive the data from the below hashmap 

//@DataProvider
//public Object[][] getData() throws IOException {
//
//	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+ "//src//test//java//Akileshreddy//data//AkileshOrder.json");
//	return new Object[][] { {data.get(0),data.get(1)} };
//}




//HashMap or below method can also be used for collecting data
//@DataProvider
//public Object[][] getData() {
//	return new Object[][] { {"akileshnikki@outlook.com","Akilesh@123","ADIDAS ORIGINAL"}, {"akileshnikki@outlook.com","Akilesh@123","ZARA COAT 3"} };
//}




//or
	


@DataProvider
public Object[][] getData() {
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("email", "akileshnikki@outlook.com");
	map.put("password", "Akilesh@123");
	map.put("item", "ADIDAS ORIGINAL");
	
	HashMap<String, String> map1 = new HashMap<String, String>();
	map1.put("email", "akileshnikki@outlook.com");
	map1.put("password", "Akilesh@123");
	map1.put("item", "ZARA COAT 3");
	return new Object [][] {{map},{map1}};
}
}
