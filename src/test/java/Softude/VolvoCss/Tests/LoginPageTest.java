package Softude.VolvoCss.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Softude.VolvoCss.PageObjects.QuestionBank;
import Softude.VolvoCss.TestComponents.BaseTest;

public class LoginPageTest extends BaseTest{
	
 	 	@Test(groups= {"LoginError"},retryAnalyzer=Softude.VolvoCss.TestComponents.Retry.class)
 	 	public void errorMessagValidationOnWrongPassword() {
 	 	landingPage.login("superadmin@yopmail.com", "Admin@23");
	    Assert.assertEquals("Opps! You have entered invalid credentials",landingPage.loginErrorMessage());
	}
 	 	@Test
 	 	public void errorMessageValidationOnWrongEmail() {
 	 		landingPage.login("Admin@yopmail.com","Admin@123");
 	 		Assert.assertEquals("Opps! You have entered invalid credentials", landingPage.loginErrorMessage());
 	 	}
	@Test
	public void forgotPasswordValidation() {
		String message=landingPage.forgotPassword("superAdmin@yopmail.com");
		Assert.assertEquals("A reset password link sent on your email id.", message);
	}
	
}
