package com.ts.core;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sharedutils.MasterDto;
import com.ts.utils.MasterClass;

public class CountryMaster extends MasterClass {

	//@Test
	public void addCounty(MasterDto masterDto) throws InterruptedException, Exception {
		Thread.sleep(1000);

		navigateToPage.countryMasterPage();
		
		//		if(homePage.countryMaster().isDisplayed()) {
		//
		//			homePage.countryMaster().click();			
		//
		//		} else {
		//
		//			homePage.master().click(); 
		//			Thread.sleep(1000);
		//
		//			homePage.countryMaster().click();			
		//		}

		String country = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Country"), "");
		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "Country Master page");

		try {

			countryMasterPage.addCountry().click(); 

			reportHelper.generateLogWithScreenshot(test, "Country add page");
			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "Remark :"+remark);

			genericHelper.insertDataIntoField(countryMasterPage.country(), masterDto.getAttributeValue("Country"));
			genericHelper.insertDataIntoField(countryMasterPage.remark(), masterDto.getAttributeValue("Remark"));

			reportHelper.generateLogWithScreenshot(test, "Before save");

			saveAndUpdateAction(test, commonFields.addBtn(), commonFields.cancelBtn(), expectedOutput);

		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}

		driver.navigate().refresh();
		String sucessMsg = "Record Inserted !!!";
		
		
		if (tostifyMessage.contains(sucessMsg))
		{
			String action = countryMasterPage.viewAction().getAttribute("class");
			
			reportHelper.performAssert(test, "Action", "edit", action);
			reportHelper.performAssert(test, "Sr no", "1", countryMasterPage.viewSrno().getText()); 
			reportHelper.performAssert(test, "County", country, countryMasterPage.viewCountry().getText());
			reportHelper.performAssert(test, "Status", "Active", countryMasterPage.viewStatus().getText());
			reportHelper.performAssert(test, "Created By", createdBy, countryMasterPage.viewCreatedBy().getText());
			String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
			if(countryMasterPage.viewCreatedAt().getText().contains(createdAt))  
			{ 
			reportHelper.performAssert(test, "Created At", createdAt, countryMasterPage.viewCreatedAt().getText());
			}
		}
		else 
		{
//			reportHelper.generateLog(test, "No data found");
//			reportHelper.generateLog(test, "Expected output : "+expectedOutput);
		}


	}

	@Test
	public void editCounty(MasterDto masterDto) throws InterruptedException, Exception {

		Thread.sleep(1000); 
		navigateToPage.countryMasterPage();

		String country = masterDto.getAttributeValue("Country");
		String searchCountry = masterDto.getAttributeValue("Search");
		String remark = masterDto.getAttributeValue("Remark");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String status = masterDto.getAttributeValue("Status");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "Country Master page");
		try {
			test = reportHelper.createTestCase(test, extentReports, masterDto);

			searchData(searchCountry);
 
			//			genericHelper.insertDataIntoField(commonFields.searchField(), searchCountry);
			//
			//			commonFields.searchBtn().click();

			String countryName = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[3]/div")).getText();

			if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')]")).isDisplayed()) 
			{

				reportHelper.performAssert(test, "Country name", searchCountry, countryName);

				if (searchCountry.equalsIgnoreCase(countryName)) 
				{

					countryMasterPage.editBtn().click();
					if (country != null && !country.isEmpty()) {

						genericHelper.insertDataIntoField(countryMasterPage.country(), country);
					}

					if (remark != null && !remark.isEmpty()) {

						genericHelper.insertDataIntoField(countryMasterPage.remark(), remark);
					}

					if (status != null && !status.isEmpty()) {

						statusSelection(stateMasterPage.activeStatus(), stateMasterPage.deactiveStatus(), status);

					}

					reportHelper.generateLogFullScreenSS(test, "Before Save");

					saveAndUpdateAction(test, commonFields.updateBtn(), commonFields.cancelBtn(), expectedOutput);
				
					
					driver.navigate().refresh();
					
					
					String msg ="Record Updated !!!";
					
					
					if (tostifyMessage.contains(msg))
					{
						String action = countryMasterPage.viewAction().getAttribute("class");
						
						reportHelper.performAssert(test, "Action", "edit", action);
						reportHelper.performAssert(test, "Sr no", "1", countryMasterPage.viewSrno().getText()); 
						reportHelper.performAssert(test, "County", country, countryMasterPage.viewCountry().getText());
						reportHelper.performAssert(test, "Status", "Active", countryMasterPage.viewStatus().getText());
						reportHelper.performAssert(test, "Updated By", updatedBy, countryMasterPage.viewUpdatedBy().getText());
						String updatedAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
						if(countryMasterPage.viewUpdatedAt().getText().contains(updatedAt))  
						{ 
						reportHelper.performAssert(test, "Updated At", updatedAt, countryMasterPage.viewUpdatedAt().getText());
						}
					}
					else 
					{
//						reportHelper.generateLog(test, "No data found");
//						reportHelper.generateLog(test, "Expected output : "+expectedOutput);
					}
				
				}

				else 
				{
					reportHelper.generateLog(test, "Search failed");
				}
			}
			else 
			{
				reportHelper.generateLog(test, "No data found");
				reportHelper.generateLog(test, "Expected output : "+expectedOutput);
			}
		}
		catch (Exception e)
		{
			reportHelper.generateLog(test, "Exception : "+e);
		}
	}

	@Test
	public void gridViewCounty(MasterDto masterDto) throws InterruptedException, Exception 
	{

		navigateToPage.countryMasterPage();
		Thread.sleep(1000);

		String expectedCountry = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Country"), "");
		String searchCountry = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Search"), "");
		//String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String expectedStatus = masterDto.getAttributeValue("Status");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		searchData(searchCountry);

		if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')]")).isDisplayed()) 
		{

			//reportHelper.performAssert(test, "Country name", searchCountry, countryName);

			
			
			String actualCountry = countryMasterPage.viewCountry().getText();
			String actualStatus = countryMasterPage.viewStatus().getText();
			String actualCreatedBy = countryMasterPage.viewCreatedBy().getText();
			String actualCreatedAt = countryMasterPage.viewCreatedAt().getText();
			String actualUpdatedAt = countryMasterPage.viewUpdatedAt().getText();
			String actualUpdatedBy = countryMasterPage.viewUpdatedBy().getText();

			System.out.println(actualCountry + actualStatus);
			Thread.sleep(1000);

			reportHelper.performAssert(test, "Country", expectedCountry, actualCountry);

			//genericHelper.compareStrings(expectedCountry, actualCountry);

			reportHelper.performAssert(test, "Status", expectedStatus, actualStatus);

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
			reportHelper.generateLog(test, "Updated At : "+actualUpdatedAt);

		}
		//genericHelper.compareStrings(expectedStatus, actualStatus);

		else 
		{
			reportHelper.generateLog(test, "No data found");
			reportHelper.generateLog(test, "Expected output : "+expectedOutput);
		}
		reportHelper.generateLog(test, "Expected Output : "+expectedOutput);



	}

}