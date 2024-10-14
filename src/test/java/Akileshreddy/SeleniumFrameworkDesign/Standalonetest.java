package Akileshreddy.SeleniumFrameworkDesign;

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

public class Standalonetest {

// This is an ecommerce project will be usefull as an example in realtime...Keep it for Reference

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String productList = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		
		Landingpage landingPage = new Landingpage(driver);
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("akileshnikki@outlook.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Akilesh@123");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
   WebElement it =    items.stream().filter(item-> 
        item.findElement(By.cssSelector("b")).getText().equals(productList)).findFirst().orElse(null);
   
   it.findElement(By.cssSelector(".card-body button:last-of-type")).click();
   
  
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
   //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
   
   //or for the above we can also write for webelement wait instead of loactor wait as below 
   //(I have commented above line(39) cuz we can use both))
   
   wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
   
   driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
   
   List<WebElement> prodNames = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
   
  // prodNames.stream().filter(prodName-> prodName.getText().equalsIgnoreCase(productList));
   
   //In the above code what we written is correct but we don't want to return anything we just
   //want to match with the product that placed in cart so below is the code to match.
   
  Boolean match =  prodNames.stream().anyMatch(prodName-> prodName.getText().equalsIgnoreCase(productList));
  Assert.assertTrue(match);
   
   driver.findElement(By.cssSelector(".totalRow button")).click();
   
   Actions akki = new Actions(driver);
   akki.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "India").build().perform();
   
   wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
   
   driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
   
   driver.findElement(By.cssSelector(".btnn")).click();
   
  String confirmMessage =  driver.findElement(By.cssSelector(".hero-primary")).getText();
   
  Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
  
  driver.close();
  
	}
	
	
	
	
	
	
	

}
