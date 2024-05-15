package com.curahealthcare.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.curahealthcare.pageobject.HomePageObjects;
import com.curahealthcare.pageobject.LoginPageObjects;

public class TC_LoginPage_002 extends BaseClass {
	ExtentTest testCase;
	@Test
	public void loginTest() {
		
		logger.info("url is opened");
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		
		homePageObjects.clickMakeAppoinment();
		logger.info("Make appoinment is clicked");
		//testCase.log(S, null)
		
		LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.setUsername(username);
		logger.info("Entered username");
		loginPageObjects.setPassword(password);
		logger.info("Entered password");
		loginPageObjects.clickLogin();
		logger.info("Login button is clicked");
		if(driver.getTitle().equals("CURA Healthcare Service")) {
		//This if statement is used to fail the testcase and get the screenshot
		//if(driver.getTitle().equals("Login")) {
			Assert.assertTrue(true);
		}
		else {
			
			try {
				captureScreen(driver,"loginTest");
				Assert.assertTrue(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
