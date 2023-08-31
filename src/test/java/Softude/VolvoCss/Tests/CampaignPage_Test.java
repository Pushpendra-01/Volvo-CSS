package Softude.VolvoCss.Tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Softude.VolvoCss.PageObjects.CampaignPage;
import Softude.VolvoCss.PageObjects.QuestionBank;
import Softude.VolvoCss.PageObjects.SurveyTemplatePage;
import Softude.VolvoCss.TestComponents.BaseTest;


public class CampaignPage_Test extends BaseTest {

	@Test(dataProvider="getData",groups= {"multipleCampaigns"})
	public void serachCustomerAndAdd(HashMap<String,String>input) throws InterruptedException {
		QuestionBank questionBank=landingPage.login("superadmin@yopmail.com", "Admin@123");
		SurveyTemplatePage surveyTemplatePage=questionBank.goToSurveyTemplate();
		CampaignPage campaignPage=surveyTemplatePage.goToCamapaignPage();
		campaignPage.createNewCampaign();
 	    campaignPage.selectQuarter(input.get("Quarter"));
 	    campaignPage.selectYear("2023-24");
 	    campaignPage.selectSurveyTemplate("Aftermarket Survey - Truck_Scripted Survey Template");
 	    campaignPage.selectStartDate("September 2023","1");
 	    campaignPage.selectEndDate("September 2023","30");
 	    campaignPage.enterTargetedResponseRate("98");
 	    campaignPage.enterFirstSmsText("Hello i am the First Scripted Sms");
 	    campaignPage.enterFollowUpSmsText("Hello i am the Scripted Follow up Sms");
 	    campaignPage.enterThankYouSms("Hello i am the Scripted Thank you Sms");
    	campaignPage.goToCustomerSelectionPage();
 	    campaignPage.selectRegionWiseCustomer(input.get("Region"));
	}
	@DataProvider()
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Softude\\VolvoCss\\data\\QuatersAndResgions.json");
		return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	}
	
	
	
	
	
//	@DataProvider()
//	public Object[][] getData() {
//		return new Object[][] {{"Q1","North"},{"Q3","East"},{"Q2","South"}};
//	}
	

//	@DataProvider()
//	public Object[][] getData() {
//		HashMap<String,String>map=new HashMap<String,String>();
//		map.put("Quarter","Q1");
//		map.put("Region","North");
//		HashMap<String,String>map1=new HashMap<String,String>();
//		map1.put("Quarter","Q2");
//		map1.put("Region","West");
//		HashMap<String,String>map2=new HashMap<String,String>();
//		map2.put("Quarter","Q1");
//		map2.put("Region","East");
//		
//		return new Object[][] {{map},{map1},{map2}};
//	}
}
