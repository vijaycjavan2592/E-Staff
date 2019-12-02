package com.staff.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.staff.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='fas fa-caret-down']")
	WebElement clickLogoutDropdown;
	
	@FindBy(xpath = "//div[@class='logout-div dis-block']")
	WebElement clickLogoutMenu;
	
	@FindBy(xpath = "//span[@class='custom-user']")
	WebElement userNameLabel;
	
	//Click on Menu button
	@FindBy(xpath = "//div[@id='hamburgerMenuIcon']")
	WebElement clickOnMenuButton;
	
	//Click on Companies menu
	@FindBy(xpath = "//div[@class='nav-item companies']")
	WebElement clickCompaniesOption;
	
	//Click on Consultant menu
	@FindBy(xpath = "//div[@class='nav-item consultants']")
	WebElement clickConsultantOption;
	
	//Click on Requirement menu
	@FindBy(xpath = "//div[@class='nav-item requirements']")
	WebElement clickRequirementOption;
		
	//Click on Placement menu
	@FindBy(xpath = "//label[contains(text(),'Placements')]")
//	@FindBy(xpath = "//label[@class='nav-item-label'][contains(text(),'Placements')]")
//	@FindBy(xpath = "//div[@class='nav-item placements remove-padding-left remove-padding-right']")
	WebElement clickPlacementOption;
	
	public boolean verifyCorrectUserName() {
		//System.out.println(userNameLabel.getText());
		return userNameLabel.isDisplayed();		
	}
	
	public CompaniesPage clickOnCompaniesOption() {
		clickOnMenuButton.click();
		clickCompaniesOption.click();
		return new CompaniesPage();		
	}
	
	
	public ConsultantPage clickOnConsultantOption() throws InterruptedException, AWTException {
		Thread.sleep(2000);		
		clickOnMenuButton.click();
		Thread.sleep(1000);
	/*	System.out.println("Text is : "+clickConsultantOption.getText());
		System.out.println("Size is : "+clickConsultantOption.getSize().getWidth());
		System.out.println("Size is : "+clickConsultantOption.getSize().getHeight());*/
		
		Robot robot = new Robot();
		int x = 210;
		int y = 240;
		
		
	/*	int z= clickConsultantOption.getLocation().getX();
		int z1= clickConsultantOption.getLocation().getY();
		System.out.println("...."+z+"...."+z1);*/
		
		robot.mouseMove(x,y);
		
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		 
		//clickConsultantOption.click();
		
		return new ConsultantPage();		
	}
	
	public RequirementPage clickOnRequirementOption() throws InterruptedException, AWTException {
		WebElement el = driver.findElement(By.xpath("//span[@class='MM-modal-close']"));
		if(el.isDisplayed()) {
			el.click();			
		}
		clickOnMenuButton.click();
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		int x = 100;
		int y = 360;
		
		
	/*	int z= clickConsultantOption.getLocation().getX();
		int z1= clickConsultantOption.getLocation().getY();
		System.out.println("...."+z+"...."+z1);*/
		
		robot.mouseMove(x,y);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//clickRequirementOption.click();
		return new RequirementPage();		
	}
	
	
	public PlacementPage clickOnPlacementOption() throws InterruptedException, AWTException {
		clickOnMenuButton.click();
		Thread.sleep(1000);
		
		Robot robot = new Robot();
		int x = 310;
		int y = 350;
		
		
	/*	int z= clickConsultantOption.getLocation().getX();
		int z1= clickConsultantOption.getLocation().getY();
		System.out.println("...."+z+"...."+z1);*/
		
		robot.mouseMove(x,y);
		
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		//clickPlacementOption.click();
		return new PlacementPage();		
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
