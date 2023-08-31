package Softude.VolvoCss.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Softude.VolvoCss.PageObjects.QuestionBank;
import Softude.VolvoCss.TestComponents.BaseTest;

public class QuestionBankTest extends BaseTest{

	@Test(dataProvider="getData")
	public void addingNewQuestion(HashMap<String,String>input) throws InterruptedException {
		QuestionBank questionBank=landingPage.login("superadmin@yopmail.com", "Admin@123");
		questionBank.goToQuestionBank();
		questionBank.createNewQuestion();
		questionBank.selectDomain(input.get("Domain"));
		questionBank.selectAfterMarketTouchPoint(input.get("AfterMarketTouchPoint"));
		questionBank.selectQuestionType(input.get("QuestionType"));
		questionBank.selectCustomerCommitment(input.get("CustomerCommitment"));
		questionBank.writeYourQustion(input.get("Question"));
		questionBank.helpText(input.get("HelpText"));
		questionBank.fillingTheOptions();
		
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Softude\\VolvoCss\\data\\QuestionsAndHelpText.json");
	    return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)}};
	}

	
}
