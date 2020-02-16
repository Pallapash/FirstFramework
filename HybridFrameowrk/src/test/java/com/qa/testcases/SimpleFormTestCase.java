package com.qa.testcases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.basepkg.BaseClass;
import com.qa.pages.SimpleFormPage;
import com.qa.utilities.AppConfigurataions;
import com.qa.utilities.TestListener;

@Listeners(TestListener.class)
public class SimpleFormTestCase extends BaseClass {

	//public static WebDriver driver;
	public AppConfigurataions config;
	public SimpleFormPage simpleform;;

	@BeforeClass
	public void setup() throws IOException {
		driver = initializeDriver();
		simpleform = new SimpleFormPage(driver);
		simpleform.clickOnInputForm();

	}

	@Test(priority = 1)
	public void VerifyPageTitle() {
		AssertJUnit.assertEquals(simpleform.launchSimpleForm(), "ABC");
	}

	@Test(priority = 2)
	public void VerifyMsg() throws InterruptedException {
		Thread.sleep(10);
		simpleform.enterMessage("ABC");
		simpleform.clickShowMsgBtn();
		AssertJUnit.assertEquals(simpleform.getUserMsg(), "ABC");
	}

	@AfterMethod
	@AfterClass
	public void tearDown() {
		CloseAllDriver();
	}

}
