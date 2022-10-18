package com.FinalSelenium.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FinalSelenium.Pages.LoginPage;


public class LoginTest extends TestBase
{
	LoginPage loginpage;

	@Test 
	public void verifyThatUserCanLoginSuccessfully() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		Assert.assertTrue(loginpage.getLoginStatus());

	}

	  @Test 
	  public void verifyInvalidCredentialWarningmessage() { 
	  loginpage = new LoginPage(driver);
	  String actualAlertmessage =loginpage.getInvalidLoginErrorMessage(); 
	  String expectedAlertmessage = "×\n"+ "Alert!\n" + "Invalid Username/Password";
	  Assert.assertEquals(actualAlertmessage, expectedAlertmessage);
	  
	  }
	  
	  @Test
	  public void verifyThatAdminCanLogoutSuccessfully() {
	  loginpage = new
	  LoginPage(driver); loginpage.login(); 
	  String actual = loginpage.getLoginInMessage(); 
	  String expected ="Sign in to start your session"; 
	  Assert.assertEquals(actual, expected);
	  
	  }
	 
}
