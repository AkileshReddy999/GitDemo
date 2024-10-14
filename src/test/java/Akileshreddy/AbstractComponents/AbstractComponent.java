package Akileshreddy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Akileshreddy.SeleniumFrameworkDesign.Cartpage;
import Akileshreddy.SeleniumFrameworkDesign.Orderpage;

public class AbstractComponent

{

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*=myorders]")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	

	public void waitForElementToDisAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public Cartpage goToCartPage() {

		cartHeader.click();
		Cartpage cartPage = new Cartpage(driver);
		return cartPage;

	}
	public Orderpage goToOrderPage() {
		orderHeader.click();
		Orderpage orderPage = new Orderpage(driver);
		return orderPage;
		
	}

}
