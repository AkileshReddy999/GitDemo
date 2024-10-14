package Akileshreddy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Akileshreddy.AbstractComponents.AbstractComponent;

public class Productcatalogue extends AbstractComponent {
	
	WebDriver driver;

	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".mb-3")
	List<WebElement> items;
	
	@FindBy(css=".ng-animating")
	WebElement noVisual;
	
	
	
	
	
	By itemsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By visualMessage = By.id("toast-container");
	
	public List<WebElement> getItemsList()
	{
		waitForElementToAppear(itemsBy);
		return items;
	}
	
	
	
	public WebElement getItemName(String itemName) 
	{
		WebElement it =   getItemsList().stream().filter(item-> 
	    item.findElement(By.cssSelector("b")).getText().equals(itemName)).findFirst().orElse(null);
		return it;
		
	}
	
	public void addProductToCart(String itemName)
	{
		WebElement it = getItemName(itemName);
		it.findElement(addToCart).click();
		waitForElementToAppear(visualMessage);
		waitForElementToDisAppear(noVisual);	
	}
	
	
	
	
}
