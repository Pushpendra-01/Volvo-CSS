package Softude.VolvoCss.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;







public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	 
	 
	public void waitingForInvisibilityofOverlappingElement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	 	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
	}
	public void waitingForVisibilityOfElement(WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	public void waitingForElementTobeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
//	public void goToServeyTemplatePage() {
//		waitingForInvisibilityofOverlappingElement();
//	 	surveyPage.click();
//	}
//	public void goToCampaignPage() {
//		waitingForInvisibilityofOverlappingElement();
//		campaignPage.click();
//	}
	
}
