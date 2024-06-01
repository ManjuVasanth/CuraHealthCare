package com.curahealthcare.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.curahealthcare.pageobject.HomePageObjects;
import com.curahealthcare.pageobject.LoginPageObjects;
import com.curahealthcare.pageobject.MakeAppoinmentPageObjects;

public class TC_MakeAppoinmentPage_003 extends BaseClass {
	@Test
	public void makeAppoinment() throws InterruptedException {
		
		logger.info("url is opened");
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		
		homePageObjects.clickMakeAppoinment();
		logger.info("Make appoinment is clicked");
		
		LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.setUsername(username);
		logger.info("Entered username");
		loginPageObjects.setPassword(password);
		logger.info("Entered password");
		loginPageObjects.clickLogin();
		logger.info("Login button is clicked");
		
		MakeAppoinmentPageObjects makeappoinmentPageObjects = new MakeAppoinmentPageObjects(driver);
		makeappoinmentPageObjects.selectFacility(facilityname);
		logger.info("Facilityname is clicked");
		makeappoinmentPageObjects.selectHealthCareProgram();
		logger.info("HealthCareProgram is selected");
		makeappoinmentPageObjects.setDateSelection(visitdate);
		logger.info("visitdate is selected");
		
		makeappoinmentPageObjects.clickBookAppoinment();
		logger.info("BookAppoinment is clicked");
		
	boolean confirmation =	driver.getPageSource().contains("Appointment Confirmation");
	
	if(confirmation==true) {
		Assert.assertTrue(true);
		System.out.println("Please be informed that your appointment has been booked");
		logger.info("Appoinment is booked");
	}
	else {
		Assert.assertTrue(false);
	
		try {
			captureScreen(driver,"makeAppoinment");
			logger.info("Appoinment is not booked");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

}
