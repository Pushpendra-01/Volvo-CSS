package Softude.VolvoCss.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Softude.VolvoCss.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		 	 	WebDriver driver=new FirefoxDriver();
		 	 	driver.manage().window().maximize();
		 	 	driver.get("https://volvocsscms.siplsolutions.com/login");
		 	 	
		 	 	driver.findElement(By.id("email")).sendKeys("superadmin@yopmail.com");
		 	 	driver.findElement(By.id("password")).sendKeys("Admin@123");
		 	 	driver.findElement(By.tagName("button")).click();
		 	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	 	driver.findElement(By.xpath("//a[@href='https://volvocsscms.siplsolutions.com/question']")).click();
		 	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 		driver.findElement(By.xpath("//span[.='Add Question']")).click();
		 		driver.findElement(By.cssSelector(".select2-selection:first-child")).click();
		 		driver.findElement(By.xpath("//li[.='Aftermarket Survey - Truck']")).click();
                
		 		driver.findElement(By.xpath("//input[@placeholder='Select']")).click();
		 		Actions action=new Actions(driver);
		 		action.moveToElement(driver.findElement(By.cssSelector("ul[id='select2-aftermarket_touch_point-results'] li:nth-child(3)"))).click().build().perform();
		 		//Select select=new Select(driver.findElement(By.id("aftermarket_touch_point")));
		 		
		 		driver.findElement(By.id("select2-questionType-container")).click();
		 		action.moveToElement(driver.findElement(By.cssSelector("ul[id='select2-questionType-results'] li:nth-child(2)"))).click().build().perform();
		 		driver.findElement(By.id("select2-customerCommitmentType-container")).click();
		 		action.moveToElement(driver.findElement(By.cssSelector("ul[id='select2-customerCommitmentType-results'] li:nth-child(2)"))).click().build().perform();
		 		driver.findElement(By.id("question-text")).sendKeys("Hello this is Automation Question");
		 		driver.findElement(By.id("help-text")).sendKeys("Automation_Help Text");
		 		for(int i=0;i<=7;i++) {
		 			driver.findElement(By.cssSelector("button")).click();
		 		}
// hitting the Add More button.
		 		for (int i = 1; i <= 10; i++) {
		 		    String xpath = "(//input[@placeholder='Option'])[" + i + "]";
		 		    driver.findElement(By.xpath(xpath)).sendKeys(String.valueOf(i));
		 		}
// Selecting the Red color code till the 5 rating.
		 		String css=".select2-selection__placeholder";
		 		for(int i = 0 ; i < 5; i++) {
		 			driver.findElement(By.cssSelector(css)).click();
			 		driver.findElement(By.cssSelector("li[role='option']:nth-child(2)")).click();
			 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
		 		}
// Selecting the Yellow color for the 6-8 rating.
		 		for(int i=0;i<3;i++) {
		 			driver.findElement(By.cssSelector(css)).click();
		 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
			 		driver.findElement(By.cssSelector("li[role='option']:nth-child(3)")).click();
		 		}
//	Selecting the Green color for rating 9 & 10.	 		
		 		
		 		for(int i=0;i<2;i++) {
		 			driver.findElement(By.cssSelector(css)).click();
		 			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
			 		driver.findElement(By.cssSelector("li[role='option']:nth-child(1)")).click();
		 		}
		 	driver.findElement(By.name("submit")).click();
		 	System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		
//	landing on the Survey page		
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.cssSelector("a[href='https://volvocsscms.siplsolutions.com/survey']")).click();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.cssSelector(".d-md-inline-flex")).click();
		 	driver.findElement(By.id("select2-surveyType-container")).click();
		 	action.moveToElement(driver.findElement(By.cssSelector(".select2-results__options li:nth-child(1)"))).click().build().perform();
		 	driver.findElement(By.id("select2-aftermarket_touch_point-container")).click();
		 	action.moveToElement(driver.findElement(By.cssSelector(".select2-results__options li:nth-child(3)"))).click().build().perform();
		 	driver.findElement(By.id("survey_template_name")).sendKeys("_Automated_Servey");
		 	driver.findElement(By.id("opening_script")).sendKeys("Hello this is the Opening Script of this Survey template");
		 	driver.findElement(By.id("closing_script")).sendKeys("Hello this is the closing Script of this Survey template");
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.id("next_btn")).click();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.id("check_all_source_list")).click();
		 	driver.findElement(By.id("moveRight")).click();
		 	driver.findElement(By.name("submit")).click();
		 	System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
		    
// Creating new campaign 
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.cssSelector(".nk-menu-main li:nth-child(3)")).click();
		 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		 	driver.findElement(By.cssSelector(".d-md-inline-flex")).click();
		 	
//		 	WebElement Quarter=driver.findElement(By.id("quarter"));
//		 	Select dropdown=new Select(Quarter);
//		 	dropdown.selectByIndex(4);
		 	
		    driver.findElement(By.id("select2-quarter-container")).click();
		    action.moveToElement(driver.findElement(By.cssSelector(".select2-results__options li:nth-child(2)"))).click().build().perform();
		    driver.findElement(By.id("select2-year-container")).click();
		    action.moveToElement(driver.findElement(By.cssSelector(".select2-results__options li:nth-child(3)"))).click().build().perform();
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
          
		    driver.findElement(By.id("select2-survey_template-container")).click();
            driver.findElement(By.cssSelector(".select2-search--dropdown input")).sendKeys("Aftermarket Survey - Truck_Automated_Servey");
            action.moveToElement(driver.findElement(By.xpath("//li[.='Aftermarket Survey - Truck_Automated_Servey']"))).click().build().perform();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
            driver.findElement(By.id("startDate")).click();
            List<WebElement>options=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".datepicker-days td")));
            for(WebElement date:options) {
            	if(date.getText().equalsIgnoreCase("15")) {
            		date.click();
            		break;
            	}
            }
            WebElement endDateInput=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("endDate"))));
            endDateInput.click();
//            List<WebElement>EndDateOpt = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".datepicker-days td")));
//            for(WebElement endDate:EndDateOpt) {
//            	if(endDate.getText().equalsIgnoreCase("30")) {
//            		endDate.click();
//            		break;
//            	}
//            }
          
            driver.findElement(By.xpath("(//td[text()='30'])[2]")).click();
            
            String firstSms="Hello this is the first sms text from the Automation";
            String followUpSms="Hello this is the follow-up Sms from the Automation";
            String thankYouSms="Hello this is the Thank you sms from the Automation";
            driver.findElement(By.id("targeted_response_rate")).sendKeys("98");
            
            driver.findElement(By.name("first_sms_text")).sendKeys(firstSms);
            driver.findElement(By.name("follow_up_sms_text")).sendKeys(followUpSms);
            driver.findElement(By.name("thankyou_sms_text")).sendKeys(thankYouSms);
            driver.findElement(By.id("handle_show_customers")).click();
            
//           Applying customers Regions filter.
            
            WebElement customerFilter=driver.findElement(By.cssSelector(".btn-trigger"));
            wait.until(ExpectedConditions.visibilityOf(customerFilter));
            customerFilter.click();
            WebElement filterByRegion=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Select Region']")));
            filterByRegion.click();
            List<WebElement>Regions=driver.findElements(By.cssSelector("#select2-region-results li"));
            for(WebElement Region:Regions) {
            	if(Region.getText().equalsIgnoreCase("East")) {
            		Region.click();
            		break;
            	}
            	
            }
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            
//          Selecting Customers on the basis of their name
            List<WebElement>customersName=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".transfer-box-info label")));
            for(WebElement customer:customersName) {
            	if(customer.getText().equalsIgnoreCase("Hilltop Hirise Private Limited")) {
            		customer.click();
            		break;
            	}
            }
            
         
		    
		    

	}

}
