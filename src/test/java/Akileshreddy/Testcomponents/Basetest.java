package Akileshreddy.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Akileshreddy.SeleniumFrameworkDesign.Landingpage;

public class Basetest {

	public WebDriver driver;
	public Landingpage landingPage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Akileshreddy//resources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);

		}

		else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	
	
public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		
		//READ JSON TO STRING
		//for below fileutils we have to get dependencies from commons from MVN
		
	String jsonContent = 	FileUtils.readFileToString(new File(filePath));
	
	//READT STRING TO HASHMAP
	//for below step we have to get dependencies from Jackson Databind (Hahmap) from MVN repository
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference
			<List<HashMap<String,String>>>(){});
	return data;
	
	
	}
	
	
	@BeforeMethod (alwaysRun=true)
	public Landingpage launchApplication() throws IOException {
		driver = initializeDriver();
		landingPage = new Landingpage(driver);
		landingPage.goTo();
		return landingPage;

	}

	@AfterMethod (alwaysRun=true)
	public void closeDriver() {
		driver.close();
	}

}
