package Softude.VolvoCss.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.VolvoCss.AbstractComponents.AbstractComponent;

public class CampaignPage extends AbstractComponent {

	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
        PageFactory.initElements(driver,this);
	}


	@FindBy(css=".d-md-inline-flex")
	WebElement createNewCampaign;
	@FindBy(css="#select2-quarter-container span")
	WebElement quarterContainer;
	@FindBy(css="#select2-quarter-results li")
	List<WebElement>quarterOptions;
	@FindBy(id="select2-year-container")
	WebElement yearContainer;
	@FindBy(css="#select2-year-results li")
	List<WebElement>yearOptions;
	@FindBy(id="select2-survey_template-container")
	WebElement surveyTemplateContainer;
	@FindBy(css="#select2-survey_template-results li")
	List<WebElement>surveyOptions;
	@FindBy(id="startDate")
	WebElement startDate;
	@FindBy(xpath="/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")
	WebElement month_Year;
	@FindBy(xpath="/html/body/div[3]/div[1]/table/thead/tr[2]/th[3]")
	WebElement nextBtn;
	@FindBy(css=".datepicker-days td[class='day']")
	List<WebElement>dateOpt;
	@FindBy(id="endDate")
	WebElement endDate;
	@FindBy(id="targeted_response_rate")
	WebElement targetedResponseRate;
	@FindBy(name="first_sms_text")
	WebElement firstSmsText;
	@FindBy(name="follow_up_sms_text")
	WebElement followUpSms;
	@FindBy(name="thankyou_sms_text")
	WebElement thankYouSms;
	@FindBy(id="handle_show_customers")
	WebElement showCustomerButton;
	@FindBy(css=".ni-filter-alt")
    WebElement filterBtn;
	@FindBy(css="input[placeholder='Select Region']")
	WebElement regionFilter;
	@FindBy(css="#select2-region-results li")
	List<WebElement>regions;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitFilter;
	@FindBy(css=".custom-checkbox label[class='custom-control-label']")
	WebElement checkAll;
	@FindBy(id="moveRight")
	WebElement moveRight;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(id="searchSource")
	WebElement search;
	@FindBy(css=".transfer-box-info label")
	List<WebElement>customers;
	
     public void createNewCampaign() {
		waitingForInvisibilityofOverlappingElement();
		createNewCampaign.click();
	}
	public void selectQuarter(String Quarter) {
		waitingForInvisibilityofOverlappingElement();
		waitingForElementTobeClickable(quarterContainer);
		quarterContainer.click();
		WebElement quarter=quarterOptions.stream().filter(quater->quater.getText().equalsIgnoreCase(Quarter)).findFirst().orElse(null);
		quarter.click();
	}
	public void selectYear(String Year) {
		waitingForInvisibilityofOverlappingElement();
		yearContainer.click();
		WebElement year=yearOptions.stream().filter(Y->Y.getText().equals(Year)).findFirst().orElse(null);
		year.click();
	}
	public void selectSurveyTemplate(String SurveyTemplate) {
		waitingForVisibilityOfElement(surveyTemplateContainer);
		Actions action=new Actions(driver);
		action.sendKeys(surveyTemplateContainer,SurveyTemplate ).build().perform();
		WebElement surveyOpt=surveyOptions.stream().
				filter(opt->opt.getText().equalsIgnoreCase(SurveyTemplate)).findFirst().orElse(null);
		if(surveyOpt !=null) {
			surveyOpt.click();
		}
		else {
			System.out.println("Survey Template not Found");
		}
		
	}
	public void selectStartDate(String MonthAndYear, String StartDate) {
		waitingForInvisibilityofOverlappingElement();
		startDate.click();
		while(true) {
			String monthAndYear=month_Year.getText();
			if(monthAndYear.equals(MonthAndYear)) {
				break;
			}
			else {
				nextBtn.click();
			}
		}
		WebElement startDate=dateOpt.stream().filter(StOpt->StOpt.getText().equalsIgnoreCase(StartDate)).findFirst().orElse(null);
			startDate.click();
	}
	public void selectEndDate(String MonthAndYear,String EndDate) {
		waitingForElementTobeClickable(endDate);
		waitingForInvisibilityofOverlappingElement();
		endDate.click();
		while(true) {
			String monthAndYear=month_Year.getText();
			if(monthAndYear.equals(MonthAndYear)) {
				break;
			}
			else {
				nextBtn.click();
			}
		}
		WebElement endDates=dateOpt.stream().filter(edOpt->edOpt.getText().equalsIgnoreCase(EndDate)).findFirst().orElse(null);
			endDates.click();
	}
	public void enterFirstSmsText(String FirstSmsText) {
		firstSmsText.sendKeys(FirstSmsText);
	}
	public void enterFollowUpSmsText(String FollowUpSms) {
		followUpSms.sendKeys(FollowUpSms);
	}
	public void enterThankYouSms(String ThankYouSms) {
		thankYouSms.sendKeys(ThankYouSms);
	}
	public void enterTargetedResponseRate(String TargetedResponseRate) {
		targetedResponseRate.sendKeys(TargetedResponseRate);
	}
	public void goToCustomerSelectionPage() {
		showCustomerButton.click();
	}
	public void selectRegionWiseCustomer(String Region) throws InterruptedException {
		waitingForElementTobeClickable(filterBtn);
		filterBtn.click();
		waitingForElementTobeClickable(regionFilter);
		regionFilter.click();
		WebElement region=regions.stream().filter(regionOpt->regionOpt.getText().equalsIgnoreCase(Region)).findFirst().orElse(null);
		region.click();
		submitFilter.click();
		Thread.sleep(2000);
		checkAll.click();
		moveRight.click();
	    submitBtn.click();
	}
	
	public void selectCustomerByName(String CustomerName) throws InterruptedException {
		search.sendKeys(CustomerName);
		Thread.sleep(2000);
		WebElement customer=customers.stream().filter(cust->cust.getText().equalsIgnoreCase(CustomerName)).findFirst().orElse(null);
		customer.click();
		submitBtn.click();
	}
	
}
