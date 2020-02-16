package com.qa.basepkg;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.utilities.AppConfigurataions;

public class BaseClass {

	public static WebDriver driver;

	AppConfigurataions config = new AppConfigurataions();

	public WebDriver initializeDriver() throws IOException {

		String browser=config.getBrowser();
		if (browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", config.getDriverPath());
			driver = new ChromeDriver();

			driver.get(config.AppUrl());
			driver.manage().window().maximize();

			long val=(Long.parseLong(config.getImplicitTimeVal()));
			driver.manage().timeouts().implicitlyWait(val,TimeUnit.SECONDS);
		}

		return driver;

	}

	public void CloseDriver() {
		driver.close();
	}

	public void CloseAllDriver() {
		driver.quit();
	}

}
