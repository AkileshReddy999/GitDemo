package Akileshreddy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Akileshreddy.AbstractComponents.AbstractComponent;

public class Orderpage extends AbstractComponent {
	WebDriver driver;

	
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement>productNames ;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOrderDisplay(String itemName) {

		Boolean match = productNames.stream().anyMatch(prodName -> prodName.getText().equalsIgnoreCase(itemName));
		return match;
	}

	

}
