package com.curahealthcare.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.curahealthcare.pageobject.HomePageObjects;

public class TC_HomePage_001 extends BaseClass{
	
	@Test
	public void homePageTest() {
		
		driver.get(baseUrl);
		HomePageObjects homePageObjects = new HomePageObjects(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		homePageObjects.clickMakeAppoinment();
		
		if(driver.getTitle().equals("Login")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
