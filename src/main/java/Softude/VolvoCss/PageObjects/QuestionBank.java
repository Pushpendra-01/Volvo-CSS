package Softude.VolvoCss.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import Softude.VolvoCss.AbstractComponents.AbstractComponent;

public class QuestionBank extends AbstractComponent{

	WebDriver driver;
	String domainName;
	String QuestionType;
	String CustomerCommitment;
	String AfterMarketTouchPoint;
	public QuestionBank(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//	driver.findElement(By.xpath("//a[@href='https://volvocsscms.siplsolutions.com/question']")).click();
	@FindBy(xpath="//a[@href='https://volvocsscms.siplsolutions.com/question']")
	WebElement questionBank;
//	driver.findElement(By.xpath("//span[.='Add Question']")).click();
	@FindBy(xpath="//span[.='Add Question']")
	WebElement addQuestionBtn;
//	driver.findElement(By.cssSelector(".select2-selection:first-child")).click();
	@FindBy(css=".select2-selection:first-child")
	WebElement domain;

	@FindBy(css="#select2-domain-results li")
	List<WebElement>availabelDomains;
	@FindBy(id="select2-questionType-container")
	WebElement questionTypeDropdown;
	@FindBy(css=".select2-results__options li")
	List<WebElement>questionType;
	@FindBy(id="select2-customerCommitmentType-container")
	WebElement customerCommitmentDropdown;
	@FindBy(css=".select2-results__options li")
	List<WebElement> ccType;
	@FindBy(xpath="//input[@placeholder='Select']")
	WebElement afterMarketTPDropdown;
	@FindBy(css="#select2-aftermarket_touch_point-results li")
	List<WebElement> options;
	@FindBy(name="question_text")
	WebElement questionBox;
	@FindBy(name="help_text")
	WebElement helpTextBox;
	@FindBy(tagName="button")
	WebElement AddMoreBtn;
	@FindBy(css=".select2-selection__placeholder")
	WebElement colorBox;
	By redColor=By.cssSelector("li[role='option']:nth-child(2)");
    By yellowColor=By.cssSelector("li[role='option']:nth-child(3)");
    By greenColor=By.cssSelector("li[role='option']:nth-child(1)");
    @FindBy(name="submit")
    WebElement saveButton;
    @FindBy(css=".alert-success")
    WebElement successmsg;
    @FindBy(css="a[href='https://volvocsscms.siplsolutions.com/survey']")
    WebElement surveyPage;
    @FindBy(css="#DataTables_Table_0 td:nth-child(2)")
    List<WebElement>questions;
	
	public void selectDomain(String domainName) throws InterruptedException {
//		waitingForInvisibilityofOverlappingElement();
//		questionBank.click();
//		waitingForInvisibilityofOverlappingElement();
//		addQuestionBtn.click();
		Thread.sleep(2000);
		domain.click();
		WebElement domainsName=availabelDomains.stream().filter(domains->domains.getText().equalsIgnoreCase(domainName)).findFirst().orElse(null);
 		domainsName.click();
	}
	public void goToQuestionBank() {
		waitingForInvisibilityofOverlappingElement();
		questionBank.click();
	}
	public void createNewQuestion() {
		waitingForInvisibilityofOverlappingElement();
		addQuestionBtn.click();
	}
	public void selectQuestionType(String QuestionType) {
 		questionTypeDropdown.click();
 		 WebElement questionTypes=questionType.stream().filter(s->s.getText().equalsIgnoreCase(QuestionType)).findFirst().orElse(null);
         questionTypes.click();
         
	}
	public void selectCustomerCommitment(String CustomerCommitment) {
		 customerCommitmentDropdown.click();
		 WebElement CC=ccType.stream().filter(s->s.getText().equalsIgnoreCase(CustomerCommitment)).findFirst().orElse(null);
		 CC.click();
	}
	public void selectAfterMarketTouchPoint(String AfterMarketTouchPoint) {
		waitingForInvisibilityofOverlappingElement();
		afterMarketTPDropdown.click();
	    WebElement AMTP=options.stream().filter(opt->opt.getText().equalsIgnoreCase(AfterMarketTouchPoint)).findFirst().orElse(null);
	    AMTP.click();
	}
	public void writeYourQustion(String questionText) {
		questionBox.sendKeys(questionText);
	}
	public void helpText(String HelpText) {
		helpTextBox.sendKeys(HelpText);
	}
	public void fillingTheOptions() {
		
		// hitting the Add More button.
    	for(int i=0;i<=7;i++) {
    		AddMoreBtn.click();
 		}
    	// filling the options from 1-10
    	for (int i = 1; i <= 10; i++) {
 		    String xpath = "(//input[@placeholder='Option'])[" + i + "]";
 		    driver.findElement(By.xpath(xpath)).sendKeys(String.valueOf(i));
    	}
       // selecting the red color for the 1-5 options
    	for(int i=0;i<5;i++) {
    		colorBox.click();
	 		driver.findElement(redColor).click();
	 		waitingForVisibilityOfElement(colorBox);
    	}
      // selecting the yellow color for the 6-8 rating
    	for(int i=5;i<8;i++) {
    		colorBox.click();
	 		waitingForVisibilityOfElement(colorBox);
	 		driver.findElement(yellowColor).click();
    	}
     // selecting the green color for the 9-10 rating
    	for(int i=8;i<10;i++) {
    		colorBox.click();
	 		waitingForVisibilityOfElement(colorBox);
	 		driver.findElement(greenColor).click();
    	}
    	saveButton.click();
    	System.out.println(successmsg.getText()); // printing the success message
	}
	public SurveyTemplatePage goToSurveyTemplate() {
		waitingForInvisibilityofOverlappingElement();
    	SurveyTemplatePage surveyTemplatePage=new SurveyTemplatePage(driver);
    	surveyPage.click();
    	return surveyTemplatePage;
    }
	public Boolean verifyTheQuestion(String Question) {
    	Boolean match=questions.stream().anyMatch(ques->ques.getText().equalsIgnoreCase(Question));
    	return match;
    }
	}
 
    

