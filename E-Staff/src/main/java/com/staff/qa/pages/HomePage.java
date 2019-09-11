package com.staff.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.staff.qa.base.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='fas fa-caret-down']")
	WebElement clickLogoutDropdown;
	
	@FindBy(xpath = "//div[@class='logout-div dis-block']")
	WebElement clickLogoutMenu;
	
	@FindBy(xpath = "//span[@class='custom-user']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[@id='hamburgerMenuIcon']")
	WebElement clickOnMenuButton;
	
	@FindBy(xpath = "//div[@class='nav-item companies']")
	WebElement clickCompaniesOption;
	
	public boolean verifyCorrectUserName() {
		//System.out.println(userNameLabel.getText());
		return userNameLabel.isDisplayed();		
	}
	
	public CompaniesPage clickOnCompaniesOption() {
		clickOnMenuButton.click();
		clickCompaniesOption.click();
		return new CompaniesPage();
		
	}
	
	/*public void clickOnMenuButton() {
		clickOnMenuButton.click();
	}
	*/
		
	public LoginPage logout() {
		clickLogoutDropdown.click();
		clickLogoutMenu.click();
		
		return new LoginPage();
	}

}
