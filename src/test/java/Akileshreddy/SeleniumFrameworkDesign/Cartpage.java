package Akileshreddy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Akileshreddy.AbstractComponents.AbstractComponent;

public class Cartpage extends AbstractComponent {
	WebDriver driver;

	@FindBy(xpath = "//*[@class='cartSection']/h3")
	private List<WebElement> cartProducts;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductsDisplay(String itemName) {

		Boolean match = cartProducts.stream().anyMatch(prodName -> prodName.getText().equalsIgnoreCase(itemName));
		return match;
	}

	public Checkout goToCheckout() {
		checkoutEle.click();
		Checkout checkOut = new Checkout(driver);
		return checkOut;
	}

}
