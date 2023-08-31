package Softude.VolvoCss.TestComponents;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Softude.VolvoCss.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver InitializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Softude\\VolvoCss\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
//		prop.getProperty("browser");
		
   // FirefoxDriver
		if(browserName.equalsIgnoreCase("fireFox")) {
	      WebDriverManager.firefoxdriver().setup();
	 	  driver=new FirefoxDriver();
	    	
		}
  // ChromeDriver
		else if(browserName.contains("chrome")) {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
		    if(browserName.contains("headless")) {
		    	option.addArguments("headless");
		    }
			driver=new ChromeDriver(option);
//            driver.manage().window().setSize(new Dimension(1440,900));		// to run in maximize screen.
		}
  // EdgeDriver
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Selenium jar files and driver\\Drviers\\Edge driver//msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		return driver;
	}

	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// Read from json to string
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		// String To Hashmap using JacksonDatabind dependencies.
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>>data=mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
		
	@BeforeMethod(alwaysRun=true)
	public LandingPage lunchApplication() throws IOException {
		driver=InitializeDriver();
		 landingPage=new LandingPage(driver);
		 landingPage.goTo();
		 return landingPage;
	}
	@AfterMethod(alwaysRun=true)
	public void teardown() { 
		driver.close();
	}
}
	      