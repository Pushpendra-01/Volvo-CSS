package Softude.VolvoCss.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Softude.VolvoCss.PageObjects.CampaignPage;
import Softude.VolvoCss.PageObjects.LandingPage;
import Softude.VolvoCss.PageObjects.QuestionBank;
import Softude.VolvoCss.PageObjects.SurveyTemplatePage;
import Softude.VolvoCss.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Css_Test extends BaseTest{
      String Question="Hello this question is written by the automation script";
	@Test
	public void EndToEndTest() throws IOException, InterruptedException {
		 	 	
		 	 	QuestionBank questionBank=landingPage.login("superadmin@yopmail.com", "Admin@123");
		 	 	questionBank.goToQuestionBank();
		 	 	questionBank.createNewQuestion();
		 	 	questionBank.selectDomain("Aftermarket Survey - Truck");
		 	 	questionBank.selectAfterMarketTouchPoint("Site support");
		 	 	questionBank.selectQuestionType("Radio");
		 	 	questionBank.selectCustomerCommitment("Clear Agreement");
		 	 	questionBank.writeYourQustion(Question);
		 	 	questionBank.helpText("Hello this is the help text written by the automation script");
		 	 	questionBank.fillingTheOptions();
		 	 	
		 	 	SurveyTemplatePage surveyTemplatePage=questionBank.goToSurveyTemplate();
		 	 	surveyTemplatePage.createCampaign();
		 	 	surveyTemplatePage.selectDomain("Aftermarket Survey - Truck");
		 	 	surveyTemplatePage.selectAfterMarketTouchPoint("Site support");
		 	 	surveyTemplatePage.enterSurveyTemplateName("_Scripted Survey Template");
		 	 	surveyTemplatePage.enterOpeningScript("Scripted Opening Script");
		 	 	surveyTemplatePage.enterClosingScript("Scripted Closing Script");
		 	 	surveyTemplatePage.selectAllQuestions();
		 	 	CampaignPage campaignPage=surveyTemplatePage.goToCamapaignPage();
		 	    campaignPage.createNewCampaign();
		 	    campaignPage.selectQuarter("Q1");
		 	    campaignPage.selectYear("2023-24");
		 	    campaignPage.selectSurveyTemplate("Aftermarket Survey - Truck_Scripted Survey Template");
		 	    campaignPage.selectStartDate("September 2023","1");
		 	    campaignPage.selectEndDate("September 2023","30");
		 	    campaignPage.enterTargetedResponseRate("98");
		 	    campaignPage.enterFirstSmsText("Hello i am the First Scripted Sms");
		 	    campaignPage.enterFollowUpSmsText("Hello i am the Scripted Follow up Sms");
		 	    campaignPage.enterThankYouSms("Hello i am the Scripted Thank you Sms");
		    	campaignPage.goToCustomerSelectionPage();
		 	    campaignPage.selectRegionWiseCustomer("North");
		 	 	
	}
	@Test(dependsOnMethods="EndToEndTest")
	 	public void VaidatingAddedQuestion() {
		QuestionBank questionBank=landingPage.login("superadmin@yopmail.com", "Admin@123");
		Assert.assertTrue(questionBank.verifyTheQuestion(Question));
	 	}

}
