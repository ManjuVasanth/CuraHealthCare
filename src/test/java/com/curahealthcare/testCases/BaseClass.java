package com.curahealthcare.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.concurrent.TimeUnit;

import com.curahealthcare.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseUrl = readConfig.getApplicationUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.password();
	public String facilityname = readConfig.getFacilityName();
	public String visitdate =  readConfig.getVisitDate();
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(TC_LoginPage_002.class);

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		System.setProperty("log4j2.configurationFile", "./log4j2.properties");
		logger = LogManager.getLogger(TC_MakeAppoinmentPage_003.class);
		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		default: {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);

		
		
		

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+testCaseName +".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
