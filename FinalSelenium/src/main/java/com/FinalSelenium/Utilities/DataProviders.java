package com.FinalSelenium.Utilities;

import org.testng.annotations.DataProvider;
public class DataProviders {
	ExcelUtility excel=new ExcelUtility();
	@DataProvider(name="adminUserProfileName")
	public Object [][]adminUserProfile()
	{
		return new Object [][] {{"deliveryboy1","deliveryboy1"},{"admin123","admin",},{"vidhu","vidhu"},{"qwerty","qwerty"}};
}
	@DataProvider(name="adminUser")
	public Object [][]adminUser()
	{
		
		excel.setExcelFile("LoginData", "AdminUserCredentials");
		Object data[][]=excel.getMultidimentionalData(4, 2);
		return data;
	}
}
