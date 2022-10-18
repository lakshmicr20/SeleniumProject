package com.FinalSelenium.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.FinalSelenium.Pages.AdminUserPage;
import com.FinalSelenium.Pages.LoginPage;


public class AdminUserTest extends TestBase  {
	AdminUserPage adminuserspage;
	LoginPage loginpage;

	
	@Test
	public void verifyThatNewAdminUserCanBeCreated()
	{
		adminuserspage=new AdminUserPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual=adminuserspage.createNewAdminUser("AdminUsers", "Staff");
		String expected="×\n" + 
				"Alert!\n" + 
				"User Created Successfully";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void verifyThatAdminUserDetailsCanBeUpdated()
	{
		adminuserspage=new AdminUserPage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		String actual=adminuserspage.updateUserprofile("AdminUsers", "Staff");
		String expected="×\n" + 
				"Alert!\n" + 
				"User Updated Successfully";
		Assert.assertEquals(actual, expected);
	}
}

