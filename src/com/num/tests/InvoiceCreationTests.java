package com.num.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.num.page.Home;
import com.num.page.Invoice;
import com.num.page.Login;

public class InvoiceCreationTests {
	
	static Login loginPage = new Login();
	static Home homePage = null;
	static Invoice invoicePage = null;
	
	@BeforeClass
	public static void setUp() throws Exception{
		homePage = loginPage.login();
	}
	
	@Test
	public void testInvoicePage() throws Exception{
		invoicePage = homePage.goToInvoicePage();
		invoicePage.createInvoice();
		assertEquals(invoicePage.invoiceSuccess(), "Success!");
	}
	
//	public void testInvoiceCreation() throws Exception{
//		invoicePage.createInvoice();
//	}
	
	@AfterClass
	public static void tearDown(){
		
		homePage.closeBrowser();
	}

}