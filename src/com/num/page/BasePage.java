package com.num.page;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.num.lib.DriverSetup;


public class BasePage {
	
	WebDriver driver = null;
	
	public WebDriver getDriver() throws MalformedURLException{
		this.driver = DriverSetup.getChromeDriver();
		return this.driver;
	}
	
	public WebElement findElementByXpath(String identifier){
		
		WebElement element = (new WebDriverWait(this.driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath(identifier)));
		return element;
		
	}
	
	public WebElement findElementsByXpath(String identifier, int index){
		

		return driver.findElements(By.xpath(identifier)).get(index);
		
		
	}
	
	public WebElement findElementById(String identifier){
		WebElement element = (new WebDriverWait(this.driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id(identifier)));
		return element;
	}
	
	public Boolean waitForInvisibility(String identifier){
		Boolean element = (new WebDriverWait(this.driver, 10))
				  .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(identifier)));
		return element;
	}
	
	public void goToURL(String url){
		this.driver.get(url);
	}
	
	public void closeBrowser(){
		this.driver.quit();
	}
	
	public void waitForPageLoad(String message){
		System.out.println(message);
		this.findElementByXpath("//strong[contains(text(), 'Please wait')]");
		this.waitForInvisibility("//strong[contains(text(), 'Please wait')]");
		System.out.println("Done");
	}
	
	public void sendKeysThroughAction(WebElement ele, String text){
		Actions actions = new Actions(this.driver);
		actions.moveToElement(ele);
		actions.click();
		actions.sendKeys(text).sendKeys(Keys.RETURN);
		actions.build().perform();
	}
	
	

}