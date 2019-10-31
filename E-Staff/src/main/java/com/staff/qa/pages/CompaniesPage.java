package com.staff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.staff.qa.base.BaseClass;

public class CompaniesPage extends BaseClass {
	
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='content-heading col-md-4']")
	WebElement activeCompaniesLabel;
	
	public String validateCompaniesPageURL() {
	//	System.out.println("URL is : "+driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	
	

}
