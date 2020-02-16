package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormPage {

	WebDriver driver;

	// page object Repository
	//// a[contains(.,'Input Forms')]
	@FindBy(linkText = "Input Forms")
	WebElement InputFormLink;

	//// a[contains(.,'Simple Form Demo')]

	@FindBy(linkText = "Simple Form Demo")
	WebElement SimpleFormDemoMenuOpt;

	@FindBy(xpath = "//input[@id='user-message']")
	WebElement userMessage;

	@FindBy(xpath = "//button[@onclick='showInput();']")
	WebElement showButton;

	@FindBy(xpath = "//span[@id='display']")
	WebElement outputMessage;

	// Constructor

	public SimpleFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page Operations method

	public void clickOnInputForm() {
		InputFormLink.click();
	}

	public String launchSimpleForm() {

		SimpleFormDemoMenuOpt.click();

		return driver.getTitle();
	}
	
	public void enterMessage(String msg)
	{
		userMessage.sendKeys(msg);
	}

	public void clickShowMsgBtn()
	{
		showButton.click();
	}
	
	public String getUserMsg()
	{
		return outputMessage.getText();
	}
}
