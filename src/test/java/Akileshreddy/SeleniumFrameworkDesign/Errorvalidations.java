package Akileshreddy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Akileshreddy.Testcomponents.Basetest;
import Akileshreddy.Testcomponents.Retry;

public class Errorvalidations extends Basetest {
//This the copypaste of standalone Test class....Do not confuse
// This is an ecommerce project will be usefull as an example in realtime...Keep it for Reference

	@Test(groups = {"handlingErrors"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String itemName = "ADIDAS ORIGINAL";
		 landingPage.loginApplication("akileshnikki@outlook.com", "Akile@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.error());
		
	}
		
	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String itemName = "ADIDAS ORIGINAL";

		Productcatalogue productCatalogue = landingPage.loginApplication("akileshnikki@outlook.com", "Akilesh@123");
		List<WebElement> items = productCatalogue.getItemsList();
		productCatalogue.addProductToCart(itemName);
		Cartpage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductsDisplay("ADIDAS ORIGINALS");
		Assert.assertFalse(match);
	}
	
	
}
