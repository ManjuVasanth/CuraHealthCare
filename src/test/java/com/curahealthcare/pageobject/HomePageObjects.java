package com.curahealthcare.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageObjects {
	private WebDriver localdriver;
	
	public HomePageObjects(WebDriver remotedriver){
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	@FindBy(linkText= "Make Appointment")
	private WebElement makeAppoinmentBtn;
	
	public void clickMakeAppoinment() {
		makeAppoinmentBtn.click();
	}

}
