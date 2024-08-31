package com.ts.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class NavigateToPage extends MasterClass{

	public NavigateToPage() {
		PageFactory.initElements(driver, this);
	}

	public void billTypeMasterPage() throws InterruptedException
	{
		
		try {
		
			homePage.billTypeMaster().click();
			Thread.sleep(1000); 
		} catch (Exception e) {
			genericHelper.scrollingTillWebElement(homePage.billCheckingMaster());
			homePage.billCheckingMaster().click();
			Thread.sleep(1000); 

			genericHelper.scrollingTillWebElement(homePage.vendorMaster());
			Thread.sleep(1000);
			homePage.billTypeMaster().click();		}
	
	}

	public void approvalSettingsPage() throws InterruptedException
	{
		try {

			homePage.billCheckingTransaction().click();
			Thread.sleep(1000); 

		} catch (Exception e) {
			genericHelper.scrollingTillWebElement(homePage.billCheckingMaster());
			Thread.sleep(1000); 

			homePage.billCheckingMaster().click();
			Thread.sleep(1000); 

			genericHelper.scrollingTillWebElement(homePage.approvalSettings());
			Thread.sleep(1000);
			homePage.approvalSettings().click();
			Thread.sleep(1000); 
		}
	}

	public void billCheckingTransactionPage() throws InterruptedException
	{
		if(homePage.billCheckingTransaction().isDisplayed()) {

			homePage.billCheckingTransaction().click();
			Thread.sleep(1000); 

		} else {
			genericHelper.scrollingTillWebElement(homePage.billCheckingMaster());
			Thread.sleep(1000); 

			homePage.billCheckingMaster().click();
			Thread.sleep(1000); 

			genericHelper.scrollingTillWebElement(homePage.approvalSettings());
			Thread.sleep(1000);
			homePage.billCheckingTransaction().click();
			Thread.sleep(1000); 
		}
	}

	public void billPaymentsPage() throws InterruptedException
	{
		if(homePage.billPayment().isDisplayed()) {

			homePage.billPayment().click();
			Thread.sleep(1000); 

		} else
		{

			genericHelper.scrollingTillWebElement(homePage.billCheckingMaster());
			Thread.sleep(1000); 

			homePage.billCheckingMaster().click();
			Thread.sleep(1000); 

			genericHelper.scrollingTillWebElement(homePage.approvalSettings());
			Thread.sleep(1000);
			homePage.billPayment().click();
			Thread.sleep(1000);
		}
	}

	public void vendorMasterPage() throws InterruptedException
	{
		if(homePage.vendorMaster().isDisplayed())
		{	
			homePage.vendorMaster().click(); 
			Thread.sleep(1000); 

		}
		else {


			genericHelper.scrollingTillWebElement(homePage.billCheckingMaster());

			genericHelper.clickWithjavascriptExecutor(homePage.billCheckingMaster());

			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", homePage.vendorMaster());
			Thread.sleep(1000);
			homePage.vendorMaster().click(); 
			Thread.sleep(1000); 
		}

	}
	
	public void cityMasterPage() throws InterruptedException
	{
		if(homePage.cityMaster().isDisplayed())
		{	
			homePage.cityMaster().click(); 
			Thread.sleep(1000); 

		}
		else {


			genericHelper.scrollingTillWebElement(homePage.master());

			genericHelper.clickWithjavascriptExecutor(homePage.master());

			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", homePage.cityMaster());
			Thread.sleep(1000);
			homePage.cityMaster().click(); 
			Thread.sleep(1000); 
		}
		
	}
	
	public void stateMasterPage() throws InterruptedException
	{
		if(homePage.stateMaster().isDisplayed())
		{	
			homePage.stateMaster().click(); 
			Thread.sleep(1000); 

		}
		else {


			genericHelper.scrollingTillWebElement(homePage.master());

			genericHelper.clickWithjavascriptExecutor(homePage.master());

			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", homePage.stateMaster());
			Thread.sleep(1000);
			homePage.stateMaster().click(); 
			Thread.sleep(1000); 
		}
		
	}
	
	public void customerMappingPage() throws InterruptedException {
		if(homePage.customerMapping().isDisplayed()) {
			homePage.customerMapping().click();
			Thread.sleep(2000);
		}
		else
		{
			genericHelper.scrollingTillWebElement(homePage.master());
			Thread.sleep(1000);
 
			homePage.master().click();
			Thread.sleep(1000);
 
			genericHelper.scrollingTillWebElement(homePage.customerMapping());
			Thread.sleep(1000);
			homePage.customerMapping().click();
			Thread.sleep(1000);
		}
	}
	
	public void departmentMasterPage() throws InterruptedException {
		if(homePage.departmentMaster().isDisplayed()) {
			homePage.departmentMaster().click();
			Thread.sleep(2000);
		}
		else
		{
			genericHelper.scrollingTillWebElement(homePage.master());
			Thread.sleep(1000);
 
			homePage.master().click();
			Thread.sleep(1000);
 
			genericHelper.scrollingTillWebElement(homePage.departmentMaster());
			Thread.sleep(1000);
			homePage.departmentMaster().click();
			Thread.sleep(1000);
		}
	}
	
	public void userMasterPage() throws InterruptedException {
		if(homePage.userMaster().isDisplayed()) {
			homePage.userMaster().click();
			Thread.sleep(2000);
		}
		else
		{
			genericHelper.scrollingTillWebElement(homePage.master());
			Thread.sleep(1000);
 
			homePage.master().click();
			Thread.sleep(1000);
 
			genericHelper.scrollingTillWebElement(homePage.userMaster());
			Thread.sleep(1000);
			homePage.userMaster().click();
			Thread.sleep(1000);
		}
	}
	
	
	
	public void roleMasterPage() throws InterruptedException {
		if(homePage.roleMaster().isDisplayed()) {
			homePage.roleMaster().click();
			Thread.sleep(2000);
		}
		else
		{
			genericHelper.scrollingTillWebElement(homePage.master());
			Thread.sleep(1000);
 
			homePage.master().click();
			Thread.sleep(1000);
 
			genericHelper.scrollingTillWebElement(homePage.roleMaster());
			Thread.sleep(1000);
			homePage.roleMaster().click();
			Thread.sleep(1000);
		}
	}
	
	public void countryMasterPage() throws InterruptedException
	{
		if(homePage.countryMaster().isDisplayed()) {

			homePage.countryMaster().click();			

		} else {

			homePage.master().click(); 
			Thread.sleep(1000);

			homePage.countryMaster().click();			
		}	
	}
	
	public void customerMasterPage() throws InterruptedException
	{
		if(homePage.customerMaster().isDisplayed()) {

			homePage.customerMaster().click();			

		} else {

			homePage.master().click(); 
			Thread.sleep(1000);

			homePage.customerMaster().click();			
		}	
	}
	
	
}
