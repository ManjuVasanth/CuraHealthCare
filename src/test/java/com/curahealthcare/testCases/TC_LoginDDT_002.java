package com.curahealthcare.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.curahealthcare.pageobject.LoginPageObjects;
import com.curahealthcare.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider = "LoginData" )
	public void loginDDT(String user,String pwd) {
		LoginPageObjects loginPageObjects = new LoginPageObjects(driver);
		loginPageObjects.setUsername(user);
		logger.info("username is provided");;
		loginPageObjects.setPassword(pwd);
		logger.info("password is provided");
		loginPageObjects.clickLogin();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			loginPageObjects.clickLogout();
			driver.switchTo().alert().accept();//close Logout alert
			driver.switchTo().defaultContent();
	}
	}
	//Alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		// find the Excel file
		//System.getProperty("user.dir") -> project home directory
		String path = System.getProperty("user.dir")+"/src/test/java/com/curahealthcare/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int columnCount = XLUtils.getCellCount(path,"Sheet1",1);
		String loginData[][]= new String[rownum][columnCount];
		
		for(int i =1;i<=rownum;i++) {
			for(int j=0;j<columnCount;j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;

}
}
