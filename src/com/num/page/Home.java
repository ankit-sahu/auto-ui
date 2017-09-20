package com.num.page;

public class Home extends BasePage{

	BasePage page = null;
	
	Home(){	
	}
	
	Home(BasePage driver){
		this.page = driver;
	}
	
	public Invoice goToInvoicePage() throws InterruptedException{

		page.waitForPageLoad("After clicking on login button");
		page.waitForPageLoad("Loading of home page");
		page.findElementById("add-invoice-btn-navbar-home").click();
		return new Invoice(page);
	}
	
	public void closeBrowser(){
		page.closeBrowser();
	}
	
	
}
