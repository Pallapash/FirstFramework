package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfigurataions {

	public Properties loadPropertyFile() throws IOException {
		File file = new File("AppConfigurations//AppConfig.Properties");

		FileInputStream fs = new FileInputStream(file);

		Properties prop = new Properties();
		prop.load(fs);

		return prop;
	}

	public String AppUrl() throws IOException {
		return loadPropertyFile().getProperty("AppUrl");
	}

	public String getBrowser() throws IOException {
		return loadPropertyFile().getProperty("Browser");
	}

	public String getDriverPath() throws IOException {
		return loadPropertyFile().getProperty("ChromeDriverpath");
	}
	public String getImplicitTimeVal() throws IOException
	{
		return loadPropertyFile().getProperty("ImplicitWait");
	}

	public String getScreenshotPath()throws IOException
	{
		return loadPropertyFile().getProperty("ScreenshotPath");
		
	}
	
	
}
