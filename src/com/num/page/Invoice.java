package com.num.page;

import org.openqa.selenium.WebElement;

import com.num.lib.Utility;

public class Invoice extends BasePage {
	
	BasePage page = null;
	
	Invoice(){
		
	}
	
	Invoice(BasePage driver){
		this.page = driver;
	}
	
	public String confirmInvoicePage(){
		WebElement ele = page.findElementById("create-invoice-header");
		System.out.println(ele.getAttribute("id"));
		return ele.getAttribute("id");
	}
	
	// Entering only mandatory fields
	public void createInvoice() throws InterruptedException{
		
		page.waitForPageLoad("Handling Please Wait Loading");
		WebElement invoiceEle = page.findElementByXpath("//div[contains(@class, 'select-customer')]");
		page.sendKeysThroughAction(invoiceEle, AppConfig.invoiceTo);		
		Utility.hardCodedSleep("For focus to shift to next element", 1000);
		WebElement itemEle = page.findElementsByXpath("//div[contains(@class, 'select-lineitem')]",0);
		page.sendKeysThroughAction(itemEle, AppConfig.item);
		Utility.hardCodedSleep("For focus to shift to next element", 1000);
		page.findElementById("line-item-price-0").sendKeys(AppConfig.Price);
		Utility.hardCodedSleep("For focus to shift to next element", 1000);
		page.findElementByXpath("//span[text()='SAVE']").click();
		page.waitForPageLoad("Handling Please Wait Loading");
	}
	
	public String invoiceSuccess(){
		return page.findElementByXpath("//div[text()='Success!']").getAttribute("text");
	}

}
