package com.FinalSelenium.Scripts;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.FinalSelenium.Utilities.Screenshot;
import com.FinalSelenium.constants.Constants;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

		public static Properties prop=null;
		public static WebDriver driver;
		
	  @Test
	public static void testBase() throws IOException
	  {
		  try
		  {
			prop=new Properties();
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources"+ "\\config.properties");
			prop.load(ip);
		  }
		  catch(FileNotFoundException e)
		  {
			  e.printStackTrace();
		  }
		  catch(IOException e)
		  {
			  e.printStackTrace();
		  }
	  }
	  @AfterMethod
	  
	  public void takeScreenShotOnFailure(ITestResult iTestResult) throws IOException
	  {
		  if(iTestResult.getStatus()== iTestResult.FAILURE)
		  {
			  takeScreenShotOnFailure(iTestResult.getName());
		  }
	  }
	  
	  public String takeScreenShotOnFailure(String name) throws IOException 
	  {
		 String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 String destination= System.getProperty("user.dir")+ "\\target\\"+ name + dateName + ".jpeg";
		 File finalDestination=new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return destination;
	  }

	  @Parameters("browser")
	  @BeforeTest(alwaysRun=true)
	  public void beforeTest(String browser) throws Exception 
	  {
		  testBase();
		  if(browser.equalsIgnoreCase(Constants.FIREFOXBROWSER))
		  {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 driver.manage().window().maximize();
		  }
		  else if (browser.equalsIgnoreCase(Constants.CHROMEBROWSER))
		  {
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
		  }
		  else if (browser.equalsIgnoreCase(Constants.EDGEBROWSER))
		  {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		  }
		  else
		  {
			  throw new Exception(Constants.BROWSERNOTCORRECT);
		  }
		  String baseUrl=prop.getProperty("baseUrl");
		  driver.get(baseUrl);
	  }

	  @AfterTest
	  public void afterTest() 
	  {
	   driver.close();
	  }

	}
