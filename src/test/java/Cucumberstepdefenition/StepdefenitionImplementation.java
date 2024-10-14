package Cucumberstepdefenition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Akileshreddy.SeleniumFrameworkDesign.Cartpage;
import Akileshreddy.SeleniumFrameworkDesign.Checkout;
import Akileshreddy.SeleniumFrameworkDesign.Confirmationpage;
import Akileshreddy.SeleniumFrameworkDesign.Landingpage;
import Akileshreddy.SeleniumFrameworkDesign.Productcatalogue;
import Akileshreddy.Testcomponents.Basetest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefenitionImplementation extends Basetest {
	
	
	public Landingpage landingPage;
	public Productcatalogue productCatalogue;
	public Confirmationpage confirmationPage;
	
	
	@Given("I Land on Ecommerce page")
	public void Landed() throws IOException{
		landingPage = launchApplication();
	}

	 @Given ("^Login with username(.+) and password(.+)$")
	 public void loginUsername(String username, String password) {
		 
			 productCatalogue = landingPage.loginApplication(username,password); 
	 }
	
	@When("^I add the (.+) to cart$")
	public void addProductToCart(String product) {
		List<WebElement> items = productCatalogue.getItemsList();
		productCatalogue.addProductToCart(product);	
	}
	@And("^checkout (.+) and submit order$")
	public void submitOrde(String product) {
		Cartpage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductsDisplay(product);
		Assert.assertTrue(match);
		Checkout checkout = cartPage.goToCheckout();
		checkout.selectCountry("india");
		confirmationPage = checkout.submitOrder();
	}
	@Then("{string} message displayed on confirmationpage")
	
		public void confirmationPage(String string) {
		String confirmmEssage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmmEssage.equalsIgnoreCase(string));
		driver.close();
	}
	@Then ("{string} message is displayed")
	public void errorMessage(String string1) {
		Assert.assertEquals(string1,landingPage.error());
		driver.close();
	}
	
}
