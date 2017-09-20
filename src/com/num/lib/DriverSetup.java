package com.num.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public static WebDriver driver;
	
	
	//This will eventually come from a factory, which returns driver based on the config.
	public static WebDriver getChromeDriver(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
}
