package com.curahealthcare.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MakeAppoinmentPageObjects {
	private WebDriver localdriver;
	public MakeAppoinmentPageObjects(WebDriver remotedriver) {
		localdriver = remotedriver;
		PageFactory.initElements(remotedriver,this);
	}
	@FindBy(id = "combo_facility")
	private WebElement facilityDropDown;
	
	@FindBy(id = "radio_program_medicaid")
	private	WebElement medicaidHealthCareProgram;
	
	@FindBy(id = "txt_visit_date")
	private	WebElement dateSelection;
	
	@FindBy(id = "btn-book-appointment" )
	private	WebElement btnBookAppt;
	
	public void selectFacility(String value) {
		Select select = new Select(facilityDropDown);
		select.selectByValue(value);
		
	}
	
	public void selectHealthCareProgram() {
		medicaidHealthCareProgram.isSelected();
		
	}
	public void setDateSelection(String value) {
		dateSelection.sendKeys(value);
		
	}
	public void clickBookAppoinment() {
		btnBookAppt.click();
		
	}
}
