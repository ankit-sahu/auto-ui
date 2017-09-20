package com.num.page;

import java.net.MalformedURLException;

public class Login extends BasePage{
	
	BasePage page = new BasePage();
		
		public Home login() throws MalformedURLException{
			page.getDriver();
			page.goToURL(AppConfig.AppURL);
			page.findElementById("Login-email").sendKeys(AppConfig.username);
			page.findElementById("Login-password").sendKeys(AppConfig.password);
			page.findElementById("Login-button").click();
			return new Home(page);
		}
	
}
