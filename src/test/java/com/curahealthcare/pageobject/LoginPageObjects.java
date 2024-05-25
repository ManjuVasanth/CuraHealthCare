package com.curahealthcare.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	private WebDriver localdriver;
	
	public LoginPageObjects(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver,this);
	}

	@FindBy(id = "txt-username")
	@CacheLookup
	private WebElement username;

	@FindBy(id = "txt-password")
	@CacheLookup
	private WebElement password;
	
	@FindBy(id = "btn-login")
	@CacheLookup
	private WebElement loginButton;
	
	@FindBy(linkText ="Logout")
	@CacheLookup
	private WebElement logoutBtn;
	
	public void setUsername(String uname) {
		username.sendKeys(uname);
		
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	public void clickLogout() {
		logoutBtn.click();
	}
	
	
}
