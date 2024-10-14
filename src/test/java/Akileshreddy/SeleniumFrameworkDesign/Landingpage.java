package Akileshreddy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Akileshreddy.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent{

	WebDriver driver;

	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
	
	//Below is called pagefactory
	
   @FindBy(xpath="//input[@id='userEmail']")
   WebElement userEmail;
   
   @FindBy(css="input[type='password']")
   WebElement passwordDo;
	
   @FindBy(id="login")
   WebElement submit;
   
   @FindBy(xpath="//div[contains(text(),'Incorrect email or password.')]")
   WebElement errorMessage;
   
   public  Productcatalogue loginApplication(String email, String password) 
   {
	   userEmail.sendKeys(email);
	   passwordDo.sendKeys(password);
	   submit.click();
	   Productcatalogue productCatalogue = new Productcatalogue(driver);
	   return productCatalogue;
	   
   }
   
   public String error() {
	   waitForWebElementToAppear(errorMessage);
	   return errorMessage.getText(); 
	  
   }
	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
   	

}
