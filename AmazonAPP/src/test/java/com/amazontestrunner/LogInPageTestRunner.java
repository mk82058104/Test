package com.amazontestrunner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazompom.LoginPage;
import com.amazonbusiesslib.CreateDriver;
import com.amazonbusiesslib.GetData;

public class LogInPageTestRunner {
	public WebDriver driver;
	public LoginPage page;
	
	@BeforeMethod 
	public void setUp(){
		driver=CreateDriver.getDriver();
		page=new LoginPage(driver);
	}
	
	@Test()
	public void AM_01(){
		page.mouseHover();
		page.clickOnSignIn();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx", "Sheet1", 12, 4);
		System.out.println("UserName--> " +  userName);
		page.enteruserName(userName);
		page.clickOnContinueBtn();
		String password=GetData.fromExcel("AmazonTestCase.xlsx", "Sheet1", 14, 4);
		page.enterPassword(password);
		page.clickOnContinueBtn();
		
		
	}
	
	@Test
	public void AM_02(){
		page.mouseHover();
		page.clickOnSignIn();
		String userName=GetData.fromExcel("AmazonTestCase.xlsx", "Sheet1", 19, 4);
		System.out.println("UserName--> " +  userName);
		page.enteruserName(userName);
		page.clickOnContinueBtn();
		String actualStr=page.invaliduserNameErrorMess();
		String expectedStr=GetData.fromExcel("AmazonTestCase.xlsx", "Data", 8, 0);
		System.out.println("expectedStr--> " +  expectedStr);
		Assert.assertEquals( actualStr, expectedStr);
	}

	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}


}
