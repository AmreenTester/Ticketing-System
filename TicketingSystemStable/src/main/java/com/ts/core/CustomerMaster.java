package com.ts.core;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.Map;

import org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi.generic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.lang3.StringUtils;

import com.sharedutils.MasterDto;
import com.ts.utils.MasterClass;


public class CustomerMaster extends MasterClass{

/*

	@Test
	public void addCustomer() throws InterruptedException, Exception
	{	
		String customerName = "sangeeta Mane";
		String customerType = "Bakery";
		String emailId = "sangeeta.mane@techneai.com";
		String contactnumber = "8605441288";
		String address = "lohgaon";
		String pincode = "411041";
		String country = "India";
		String state = "Maharashtra";
		String city = "pune";

		loginPage(driver, "amreens", "12345678");

		navigateToPage.CustomerMasterPage();

		customerMasterPage.addCustomer().click();



		customerMasterPage.customerName().sendKeys(customerName);

		Thread.sleep(1500);
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.customerId(), customerType);

		actions.click(customerMasterPage.customerId()).pause(20).sendKeys(customerType).pause(20).sendKeys(Keys.ENTER);
		Thread.sleep(1500);



		customerMasterPage.emailId().sendKeys(emailId);

		customerMasterPage.contactNumber().sendKeys(contactnumber);
		customerMasterPage.address().sendKeys(address);

		customerMasterPage.pincode().sendKeys(pincode);

		genericHelper.scrollingTillWebElement(customerMasterPage.countryId());
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.countryId(),country);
		Thread.sleep(1500);
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.stateId(),state);
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.cityId(),city);
		Thread.sleep(1500);
		customerMasterPage.cancel().click();

		//customerMasterPage.submit().click();



		customerMasterPage.submit().click();

		Thread.sleep(1000);

		String msg = commonFields.toastifyMsg().getText();// mesage printing record inserted!!!
		Thread.sleep(1000);

	}

	@Test
	public void editCustomer() throws InterruptedException, Exception
	{
		// Login with credentials
		loginPage(driver, "amreens", "12345678");

		// Navigate to Customer Master page
		navigateToPage.CustomerMasterPage();

		// Search for the customer by name
		customerMasterPage.text().sendKeys("\r\n" + "Sangeeta");
		customerMasterPage.Search().click();

		customerMasterPage.edit().click();

		// Define customer information to be updated
		String customerName = "Amreen Shaikh";
		String customerType = "Bakery";
		String emailId = "amreen.shaikh@techneai.com";
		String contactnumber = "9370536034";
		String address = "lohgaon";
		String pincode = "411041";
		String country = "India";
		String state = "Maharashtra";
		String city = "pune";



		// Update customer details
		// genericHelper.insertDataIntoField(customerMasterPage.customerId(), customerType);
		//customerMasterPage.customerName().sendKeys(customerName);
		//Thread.sleep(1500);

		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.customerId(), customerType);
		Thread.sleep(1500);

		customerMasterPage.emailId().sendKeys(emailId);
		customerMasterPage.contactNumber().sendKeys(contactnumber);
		customerMasterPage.address().sendKeys(address);
		customerMasterPage.pincode().sendKeys(pincode);
		genericHelper.scrollingTillWebElement(customerMasterPage.countryId());
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.countryId(), country);
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.stateId(), state);
		genericHelper.clearAndSendKeysWithjavascriptExecutor(customerMasterPage.cityId(), city);

		// Submit the updated information
		customerMasterPage.update().click();
		
		String msg = commonFields.toastifyMsg().getText();
		Thread.sleep(1000);

	}
	
	*/
	
	@Test
	public void addCustomer(MasterDto masterDto) throws InterruptedException, IOException
	{	
		// Navigate to Customer Master Page
		navigateToPage.customerMasterPage();

		try {
			// convert masterDto to String for Customer Name, Customer Type, Email Address, Contact Number, Address, Pincode, Country, State, City, Expected Output 
			String customerName = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Customer Name"), "");
			String customerType = masterDto.getAttributeValue("Customer Type");
			String emailId = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Email Address"), "");
			String contactnumber = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Contact Number"), "");
			String address = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Address"), "");
			String pincode = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Pincode"), "");
			String country = masterDto.getAttributeValue("Country");
			String state = masterDto.getAttributeValue("State");
			String city = masterDto.getAttributeValue("City");
			String expectedOutput = masterDto.getAttributeValue("Expected Output");

			// Create a test case object
			test = reportHelper.createTestCase(test, extentReports, masterDto);
 
			// Click on Add Customer button
			customerMasterPage.addCustomer().click();

			// Log the Customer Add page details
			reportHelper.generateLog(test, "Customer add page");
			reportHelper.generateLog(test, "Customer Name :"+customerName);
			reportHelper.generateLog(test, "Customer Type :"+customerType);
			reportHelper.generateLog(test, "Email Address :"+emailId);
			reportHelper.generateLog(test, "Contact Number :"+contactnumber);
			reportHelper.generateLog(test, "Address :"+address);
			reportHelper.generateLog(test, "Pincode :"+pincode);
			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "State :"+state);
			reportHelper.generateLog(test, "City :"+city);
			
			customerMasterPage.customerName().sendKeys(customerName);
			try {

				genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.customerId(), customerType);
				genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.countryId(), country);
				genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.stateId(), state);
				genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.cityId(), city);

			} catch (Exception e) {

				reportHelper.generateLog(test, "Exception : "+e);
			}
			customerMasterPage.emailId().sendKeys(emailId);
			customerMasterPage.contactNumber().sendKeys(contactnumber);
			customerMasterPage.address().sendKeys(address);
			customerMasterPage.pincode().sendKeys(pincode);
			
			
			
			// Save the Customer details in Extent Report
			reportHelper.generateLogWithScreenshot(test, "Before save");
			
			// Save the Customer details and verify the expected output
			saveAndUpdateAction(test, commonFields.addBtn(), commonFields.cancelBtn(), expectedOutput);

			driver.navigate().refresh();
			String sucessMsg = "Record Inserted !!!";


			if (tostifyMessage.contains(sucessMsg))
			{
				String action = countryMasterPage.viewAction().getAttribute("class");

				reportHelper.performAssert(test, "Action", "edit", action);
				reportHelper.performAssert(test, "Sr no", "1", customerMasterPage.viewSrno().getText()); 
				reportHelper.performAssert(test, "Customer name", customerName, customerMasterPage.viewName().getText());
				reportHelper.performAssert(test, "Customer type", customerType, customerMasterPage.viewType().getText());

				reportHelper.performAssert(test, "Status", "Active", stateMasterPage.viewStatus().getText());
				reportHelper.performAssert(test, "Created By", createdBy, stateMasterPage.viewCreatedBy().getText());
				String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(stateMasterPage.viewCreatedAt().getText().contains(createdAt))  
				{ 
					reportHelper.performAssert(test, "Created At", createdAt, stateMasterPage.viewCreatedAt().getText());
				}
			}
			else 
			{
				//				reportHelper.generateLog(test, "No data found");
				//				reportHelper.generateLog(test, "Expected output : "+expectedOutput);
			}
			
		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}
	}

	@Test
	public void editCustomer(MasterDto masterDto) throws InterruptedException, Exception
	{
		navigateToPage.customerMasterPage();

		try {
			
			String searchText = masterDto.getAttributeValue("Search");

			String customerName = masterDto.getAttributeValue("Customer Name");
			String customerType = masterDto.getAttributeValue("Customer Type");
			String emailId = masterDto.getAttributeValue("Email Address");
			String contactnumber = masterDto.getAttributeValue("Contact Number");
			String address = masterDto.getAttributeValue("Address");
			String pincode = masterDto.getAttributeValue("Pincode");
			String country = masterDto.getAttributeValue("Country");
			String state = masterDto.getAttributeValue("State");
			String city = masterDto.getAttributeValue("City");
			String expectedOutput = masterDto.getAttributeValue("Expected Output");
			String status = masterDto.getAttributeValue("Status");
			String remark = masterDto.getAttributeValue("Remark");

			// Search for the customer by name
			searchData(searchText);

			customerMasterPage.editBtn().click();


			test = reportHelper.createTestCase(test, extentReports, masterDto);
 
			reportHelper.generateLog(test, "Customer Edit page");
			reportHelper.generateLog(test, "Customer Name :"+customerName);
			reportHelper.generateLog(test, "Customer Type :"+customerType);
			reportHelper.generateLog(test, "Email Address :"+emailId);
			reportHelper.generateLog(test, "Contact Number :"+contactnumber);
			reportHelper.generateLog(test, "Remark :"+remark);

			reportHelper.generateLog(test, "Address :"+address);
			reportHelper.generateLog(test, "Pincode :"+pincode);
			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "State :"+state);
			reportHelper.generateLog(test, "City :"+city);
			
			// Enter the Customer Name, Customer Type, Country, State, City
			if (customerName != null)
				genericHelper.insertDataIntoField(customerMasterPage.customerName(), customerName);
			try {
				 
				if (customerType != null)
					genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.customerId(),
							customerType);
				if (country != null)
					genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.countryId(), country);
				if (state != null)
					genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.stateId(), state);
				if (city != null)
					genericHelper.sendKeysAndEnterWithjavascriptExecutor(customerMasterPage.cityId(), city);


			} catch (Exception e) {

				reportHelper.generateLog(test, "Exception : "+e);
			}
			// Enter the Email Address, Contact Number, Address, Pincode
			if (emailId != null) 
				genericHelper.insertDataIntoField(customerMasterPage.emailId(), emailId);
			if (contactnumber != null)
				genericHelper.insertDataIntoField(customerMasterPage.contactNumber(), contactnumber);

			if (remark != null)
				genericHelper.insertDataIntoField(customerMasterPage.remark(), contactnumber);

			
			if (address != null)
				genericHelper.insertDataIntoField(customerMasterPage.address(), address);

			if (status != null && !status.isEmpty()) {

				statusSelection(customerMasterPage.activeStatus(), customerMasterPage.deactiveStatus(), status);

			}
			
			if (pincode != null)
				genericHelper.insertDataIntoField(customerMasterPage.pincode(), pincode);

			
			
			reportHelper.generateLogWithScreenshot(test, "Before save");
			
			saveAndUpdateAction(test, commonFields.updateBtn(), commonFields.cancelBtn(), expectedOutput);

			driver.navigate().refresh();
			String msg = "Record Updated !!!";


			if (tostifyMessage.contains(msg))
			{
				String action = countryMasterPage.viewAction().getAttribute("class");

				reportHelper.performAssert(test, "Action", "edit", action);
				reportHelper.performAssert(test, "Sr no", "1", customerMasterPage.viewSrno().getText()); 
				reportHelper.performAssert(test, "Customer name", customerName, customerMasterPage.viewName().getText());
				reportHelper.performAssert(test, "Customer type", customerType, customerMasterPage.viewType().getText());

				reportHelper.performAssert(test, "Status", "Active", customerMasterPage.viewStatus().getText());
				reportHelper.performAssert(test, "Updated By", updatedBy, customerMasterPage.viewUpdatedBy().getText());
				reportHelper.performAssert(test, "Created By", createdBy, customerMasterPage.viewCreatedBy().getText());
				String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(customerMasterPage.viewCreatedAt().getText().contains(createdAt))  
				{ 
					reportHelper.performAssert(test, "Created At", createdAt, countryMasterPage.viewCreatedAt().getText());
				}
				
				String updatedAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(customerMasterPage.viewUpdatedAt().getText().contains(updatedAt))  
				{ 
					reportHelper.performAssert(test, "Updated At", updatedAt, stateMasterPage.viewUpdatedAt().getText());
				}
			}
			else 
			{
				//				reportHelper.generateLog(test, "No data found");
				//				reportHelper.generateLog(test, "Expected output : "+expectedOutput);
			}
			
		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}
	}
	
	@Test
	public void gridViewState(MasterDto masterDto) throws Exception 
	{
		navigateToPage.customerMasterPage();
		Thread.sleep(1000);

		String searchText = masterDto.getAttributeValue("Search");

		String customerName = masterDto.getAttributeValue("Customer Name");
		String customerType = masterDto.getAttributeValue("Customer Type");
	

		//state = genericHelper.handleNullString(state);

		//		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String expectedStatus = masterDto.getAttributeValue("Status");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "State Master page");

		//	String searchState, String expectedState, String expectedCountry, String expectedStatus

		searchData(searchText);

		if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')]")).isDisplayed()) 
		{
			//		stateMasterPage.searchBar().sendKeys(searchState);
			//		Thread.sleep(1000);
			//		commonFields.searchBtn().click();
			Thread.sleep(1000);

			String actualName = customerMasterPage.viewName().getText();
			String actualType = customerMasterPage.viewType().getText();
			String actualStatus = stateMasterPage.viewStatus().getText();
			String actualCreatedBy = stateMasterPage.viewCreatedBy().getText();
			String actualCreatedAt = stateMasterPage.viewCreatedAt().getText();
			String actualUpdatedAt = stateMasterPage.viewUpdatedAt().getText();
			String actualUpdatedBy = stateMasterPage.viewUpdatedBy().getText();

			Thread.sleep(1000);

			reportHelper.performAssert(test, "Customer Name", customerName, actualName);
			//genericHelper.compareStrings(expectedState, actualState);
			reportHelper.performAssert(test, "Customer type", customerType, actualType);
			//	genericHelper.compareStrings(expectedCountry, actualCountry);
			reportHelper.performAssert(test, "Status", expectedStatus, actualStatus);
			//		genericHelper.compareStrings(expectedStatus, actualStatus);

			if(actualCreatedBy.toLowerCase().contains(createdBy.toLowerCase()) || actualCreatedBy.toLowerCase().contains(username.toLowerCase()))
			{
				reportHelper.generateLog(test, "Expected Created by : "+createdBy+" or "+username+"Actual Created by : "+actualCreatedBy);
			}
			else {
				reportHelper.generateLog(test, "Expected Created by : "+createdBy+" or "+username+"Actual Created by : "+actualCreatedBy);
			}

			reportHelper.generateLog(test, "Created At : "+actualCreatedAt);

			if(actualUpdatedBy.toLowerCase().contains(updatedBy.toLowerCase()) || actualUpdatedBy.toLowerCase().contains(username.toLowerCase()))
			{
				reportHelper.generateLog(test, "Expected Updated by : "+updatedBy+" or "+username+"Actual Updated by : "+actualUpdatedBy);

			}
			else {
				reportHelper.generateLog(test, "Expected Updated by : "+updatedBy+" or "+username+"Actual Updated by : "+actualUpdatedBy);

			}
		}

		else 
		{
			reportHelper.generateLog(test, "No data found");
			reportHelper.generateLog(test, "Expected output : "+expectedOutput);
		}
		reportHelper.generateLog(test, "Expected Output : "+expectedOutput);
	}
}





