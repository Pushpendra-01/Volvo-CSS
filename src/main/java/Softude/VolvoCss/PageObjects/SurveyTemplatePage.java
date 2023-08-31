package Softude.VolvoCss.PageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.VolvoCss.AbstractComponents.AbstractComponent;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SurveyTemplatePage extends AbstractComponent {
	WebDriver driver;
	public SurveyTemplatePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    @FindBy(css="a[href='https://volvocsscms.siplsolutions.com/survey']")
    WebElement surveyPage;
    @FindBy(css=".d-md-inline-flex")
    WebElement createButton;
    @FindBy(id="select2-surveyType-container")
    WebElement domainType;
    @FindBy(css="#select2-surveyType-results li")
    List<WebElement>domainoptions;
    @FindBy(id="select2-aftermarket_touch_point-container")
    WebElement afterMarketTouchpointContainer;
    @FindBy(css="#select2-aftermarket_touch_point-results li")
    List<WebElement> touchpointOptions;
    @FindBy(id="survey_template_name")
    WebElement surveyTemplateName;
    @FindBy(id="opening_script")
    WebElement openingScript;
    @FindBy(id="closing_script")
    WebElement closingScript;
    @FindBy(id="next_btn")
    WebElement nextButton;
    @FindBy(id="check_all_source_list")
    WebElement checkbox;
    @FindBy(id="moveRight")
    WebElement moveRight;
    @FindBy(name="submit")
    WebElement submitButton;
    @FindBy(css=".alert-success")
    WebElement successMessage;
    @FindBy(css=".nk-menu-main li:nth-child(3)")
	 WebElement campaigns;
      
    
    public void createCampaign() {
		waitingForInvisibilityofOverlappingElement();
	 	createButton.click();
	 	
	}
	public void selectDomain(String DomainType) {
		waitingForInvisibilityofOverlappingElement();
		domainType.click();
		waitingForInvisibilityofOverlappingElement();
        System.out.println(domainoptions);
		WebElement domain=domainoptions.stream().filter(option->option.getText().equalsIgnoreCase(DomainType)).findFirst().orElse(null);
		if (domain != null) {
	        domain.click();
	    } else {
	        throw new NoSuchElementException("Domain not found: " + domainType);
	    }
	
	}
	public void selectAfterMarketTouchPoint(String afterMarketTouchPoint) {
		waitingForVisibilityOfElement(afterMarketTouchpointContainer);
		afterMarketTouchpointContainer.click();
		WebElement touchPoint=touchpointOptions.stream().
				filter(opt->opt.getText().equalsIgnoreCase(afterMarketTouchPoint)).findFirst().orElse(null);
		if(touchPoint != null) {
			touchPoint.click();
		}
		else {
			System.out.println("afterMarketTouchPoint not found please enter valid one");
		}
	}
    public void enterSurveyTemplateName(String SurveyTemplateName) {
	   waitingForVisibilityOfElement(surveyTemplateName);
	   surveyTemplateName.sendKeys(SurveyTemplateName);
   }
    public void enterOpeningScript(String OpeningScript) {
	   waitingForInvisibilityofOverlappingElement();
	   openingScript.sendKeys(OpeningScript);
   }
    public void enterClosingScript(String ClosingScript) {
	   closingScript.sendKeys(ClosingScript);
   }
    public void selectAllQuestions() {
	   nextButton.click();
	   waitingForInvisibilityofOverlappingElement();
	   checkbox.click();
	   moveRight.click();
	   submitButton.click();
	   System.out.println(successMessage);
   }
	public CampaignPage goToCamapaignPage() {
		waitingForInvisibilityofOverlappingElement();
		CampaignPage campaignPage=new CampaignPage(driver);
		campaigns.click();
		return campaignPage;
	}
    
	

}
    