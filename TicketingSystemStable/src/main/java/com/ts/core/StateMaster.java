package com.ts.core;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sharedutils.MasterDto;
import com.ts.utils.MasterClass;

public class StateMaster extends MasterClass {

	/*
	@Test
	public void addState() throws InterruptedException
	{ 
		String country = "India";
		String state = "Maharashtra";
		String remark = "ok"; 

		navigateToPage.stateMasterPage();

		stateMasterPage.addState().click();

		stateMasterPage.country().sendKeys(country);

		stateMasterPage.state().sendKeys(state);

		stateMasterPage.remark().sendKeys(remark);

		stateMasterPage.addState().click();
	}
	 */

	public void addState(MasterDto masterDto) throws InterruptedException, InvalidFormatException, IOException
	{
		navigateToPage.stateMasterPage();

		String country = masterDto.getAttributeValue("Country");
		String state = StringUtils.defaultIfBlank(masterDto.getAttributeValue("State"), "");
		//masterDto.getAttributeValue("State");

		//state = genericHelper.handleNullString(state);

		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");

		test = reportHelper.createTestCase(test, extentReports, masterDto);
		reportHelper.generateLogWithScreenshot(test, "State Master page");
 
		//dto.getAttribute(billCheckingTransactionSheet)
		try {

			stateMasterPage.addState().click();

			reportHelper.generateLogWithScreenshot(test, "State add page");
			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "State :"+state);
			reportHelper.generateLog(test, "Remark :"+remark);

			try {

				genericHelper.sendKeysAndEnterWithjavascriptExecutor(stateMasterPage.country(), country);

			} catch (Exception e) {

				reportHelper.generateLog(test, "Exception : "+e);
			}
			//stateMasterPage.country().sendKeys(country);

			stateMasterPage.state().sendKeys(state);

			stateMasterPage.remark().sendKeys(remark);

			reportHelper.generateLogFullScreenSS(test, "Before save");

			saveAndUpdateAction(test, commonFields.addBtn(), commonFields.cancelBtn(), expectedOutput);

			driver.navigate().refresh();
			String msg = "Record Inserted !!!";


			if (tostifyMessage.contains(msg))
			{
				String action = countryMasterPage.viewAction().getAttribute("class");

				reportHelper.performAssert(test, "Action", "edit", action);
				reportHelper.performAssert(test, "Sr no", "1", stateMasterPage.viewSrno().getText()); 
				reportHelper.performAssert(test, "County", country, stateMasterPage.viewCountry().getText());
				reportHelper.performAssert(test, "State", state, stateMasterPage.viewState().getText());

				reportHelper.performAssert(test, "Status", "Active", stateMasterPage.viewStatus().getText());
				reportHelper.performAssert(test, "Created By", createdBy, stateMasterPage.viewCreatedBy().getText());
				String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(stateMasterPage.viewCreatedAt().getText().contains(createdAt))  
				{ 
					reportHelper.performAssert(test, "Created At", createdAt, countryMasterPage.viewCreatedAt().getText());
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
	public void editState(MasterDto masterDto) throws InterruptedException, IOException
	{
		navigateToPage.stateMasterPage();

		//dto.getAttribute(billCheckingTransactionSheet)
		try {

			String country = masterDto.getAttributeValue("Country");

			String searchState = masterDto.getAttributeValue("Search State");
			String state = masterDto.getAttributeValue("State");
			//masterDto.getAttributeValue("State");

			//state = genericHelper.handleNullString(state);

			String remark = masterDto.getAttributeValue("Remark");
			//		remark = genericHelper.handleNullString(remark);
			String expectedOutput = masterDto.getAttributeValue("Expected Output");
			String status = masterDto.getAttributeValue("Status");

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			reportHelper.generateLogWithScreenshot(test, "State Master page");

			searchData(searchState);

			String stateName = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[3]/div")).getText();

			if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')])")).isDisplayed()) {

				reportHelper.performAssert(test, "State name", searchState, stateName);

				if (searchState.equalsIgnoreCase(stateName)) 
				{
					stateMasterPage.editBtn().click();

					reportHelper.generateLogWithScreenshot(test, "State add page");

					reportHelper.generateLog(test, "Country :"+country);
					reportHelper.generateLog(test, "State :"+state);
					reportHelper.generateLog(test, "Remark :"+remark);

					if (country != null && !country.isEmpty()) {

						try {
							genericHelper.sendKeysAndEnterWithjavascriptExecutor(stateMasterPage.country(), country);

						} catch (Exception e) {
							// TODO: handle exception
						}

						//					stateMasterPage.country().clear();
						//					stateMasterPage.country().sendKeys("India");
					}

					if (state != null && !state.isEmpty()) {

						genericHelper.insertDataIntoField(stateMasterPage.state(), state);

						//					stateMasterPage.state().clear();
						//					stateMasterPage.state().sendKeys("MP");
					}
					//		cityMasterPage.city().clear();
					//		cityMasterPage.city().sendKeys("Nagpur");

					if (remark != null && !remark.isEmpty()) {

						genericHelper.insertDataIntoField(stateMasterPage.remark(), remark);
						//					stateMasterPage.remark().clear();
						//					stateMasterPage.remark().sendKeys("Nagput city");
					}

					if (status != null && !status.isEmpty()) {

						statusSelection(stateMasterPage.activeStatus(), stateMasterPage.deactiveStatus(), status);

					}

					reportHelper.generateLogFullScreenSS(test, "Before Save");

					//stateMasterPage.updateBtn().click();

					saveAndUpdateAction(test, commonFields.updateBtn(), commonFields.cancelBtn(), expectedOutput);

					driver.navigate().refresh();


					String msg ="Record Updated !!!";


					if (tostifyMessage.contains(msg))
					{
						String action = countryMasterPage.viewAction().getAttribute("class");

						reportHelper.performAssert(test, "Action", "edit", action);
						reportHelper.performAssert(test, "Sr no", "1", stateMasterPage.viewSrno().getText()); 
						reportHelper.performAssert(test, "County", country, stateMasterPage.viewCountry().getText());
						reportHelper.performAssert(test, "State", state, stateMasterPage.viewState().getText());

						reportHelper.performAssert(test, "Status", "Active", stateMasterPage.viewStatus().getText());
						reportHelper.performAssert(test, "Updated By", updatedBy, stateMasterPage.viewUpdatedBy().getText());
						reportHelper.performAssert(test, "Created By", createdBy, stateMasterPage.viewCreatedBy().getText());
//						String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
//						if(stateMasterPage.viewCreatedAt().getText().contains(createdAt))  
//						{ 
//							reportHelper.performAssert(test, "Created At", createdAt, countryMasterPage.viewCreatedAt().getText());
//						}
						
						String updatedAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
						if(stateMasterPage.viewUpdatedAt().getText().contains(updatedAt))  
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
				else {
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
	public void gridViewState(MasterDto masterDto) throws Exception 
	{
		navigateToPage.stateMasterPage();
		Thread.sleep(1000);

		String expectedCountry = masterDto.getAttributeValue("Country");

		String searchState = masterDto.getAttributeValue("Search State");
		String expectedState = StringUtils.defaultIfBlank(masterDto.getAttributeValue("State"), "");
		//masterDto.getAttributeValue("State");

		//state = genericHelper.handleNullString(state);

		//		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String expectedStatus = masterDto.getAttributeValue("Status");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "State Master page");

		//	String searchState, String expectedState, String expectedCountry, String expectedStatus

		searchData(searchState);

		if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')]")).isDisplayed()) 
		{
			//		stateMasterPage.searchBar().sendKeys(searchState);
			//		Thread.sleep(1000);
			//		commonFields.searchBtn().click();
			Thread.sleep(1000);

			String actualState = stateMasterPage.viewState().getText();
			String actualCountry = stateMasterPage.viewCountry().getText();
			String actualStatus = stateMasterPage.viewStatus().getText();
			String actualCreatedBy = stateMasterPage.viewCreatedBy().getText();
			String actualCreatedAt = stateMasterPage.viewCreatedAt().getText();
			String actualUpdatedAt = stateMasterPage.viewUpdatedAt().getText();
			String actualUpdatedBy = stateMasterPage.viewUpdatedBy().getText();

			Thread.sleep(1000);

			reportHelper.performAssert(test, "State", expectedState, actualStatus);
			//genericHelper.compareStrings(expectedState, actualState);
			reportHelper.performAssert(test, "Country", expectedCountry, actualCountry);
			//	genericHelper.compareStrings(expectedCountry, actualCountry);
			reportHelper.performAssert(test, "Status", expectedStatus, expectedStatus);
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