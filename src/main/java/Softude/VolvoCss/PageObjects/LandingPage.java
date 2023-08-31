package Softude.VolvoCss.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Softude.VolvoCss.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	driver.findElement(By.id("email")).sendKeys("superadmin@yopmail.com");
	
//	Using Pagefactory for decalring element.
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(tagName="button")
	WebElement button;
	@FindBy(css=".alert-dismissible")
	WebElement errorMsg;
	@FindBy(css=".form-label-group a")
	WebElement forgotPassword;
	@FindBy(id="email")
	WebElement useremail;
	@FindBy(tagName="button")
	WebElement resetlinkBtn;
	@FindBy(css=".alert-dismissible")
	WebElement message;
	
	public QuestionBank login(String userEmail, String userPassword) {
	
		email.sendKeys(userEmail);
		password.sendKeys(userPassword);
	    button.click();
	    QuestionBank questionBank=new QuestionBank(driver);
	    return questionBank;
	}
	public void goTo() {
		driver.get("https://volvocsscms.siplsolutions.com/login");
	}
	public String loginErrorMessage() {
	return errorMsg.getText();
	}
	public String forgotPassword(String email) {
		forgotPassword.click();
		waitingForVisibilityOfElement(useremail);
		useremail.sendKeys(email);
		resetlinkBtn.click();
		waitingForVisibilityOfElement(message);
		String msg=message.getText();
		return msg;
	}
	
}
