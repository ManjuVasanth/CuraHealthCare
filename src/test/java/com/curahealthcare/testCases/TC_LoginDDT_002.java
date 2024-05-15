package com.curahealthcare.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginDDT_002 extends BaseClass{
	@Test
	public void loginDDT() {
		
	}
	
	@DataProvider(name = "LoginData")
	public void getData() {
		String path = System.getProperty("user.dir")+"/src/test/java/com/curahealthcare/testData/LoginData.xlsx";
		

}
}
