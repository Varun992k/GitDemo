package com.baseeees;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseMain {
	
	
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	//To call different browsers
	public void driverSetup()
	{
		prop=new Properties();
		
		try 
		{
			prop.load(new FileInputStream("C:\\Users\\HP\\eclipse-workspace new\\HRMSPrjoctOn\\config.properties"));
		}	
		 catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//To Open Chrome Browser
		if(prop.getProperty("browserName").matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\eclipse-workspace new\\HRMSPrjoctOn\\drivers\\chromedriver_win32\\chromedriver.exe");
			
			driver=new ChromeDriver();
		}
		
		//To Open Firefox Browser
		if(prop.getProperty("browserName").matches("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\eclipse-workspace new\\HRMSPrjoctOn\\drivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		//To maximize the Browser Window
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
//Closing the browser
	public void closeBrowser()
	{
		driver.quit();
	}

}


