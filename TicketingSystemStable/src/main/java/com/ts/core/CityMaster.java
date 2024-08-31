package com.ts.core;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.sharedutils.MasterDto;
import com.ts.utils.MasterClass;

public class CityMaster extends MasterClass {
 
	@Test
	public void addCity(MasterDto masterDto) throws InterruptedException, IOException
	{ 
		navigateToPage.cityMasterPage();
 
		String country = masterDto.getAttributeValue("Country");
		String state = masterDto.getAttributeValue("State");
		String city = StringUtils.defaultIfBlank(masterDto.getAttributeValue("City"), "");
		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");

		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		reportHelper.generateLogWithScreenshot(test, "City Master page");

		test = reportHelper.createTestCase(test, extentReports, masterDto);
 
		try {

			cityMasterPage.addBtn().click();

			reportHelper.generateLogWithScreenshot(test, "City add page");
			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "State :"+state);
			reportHelper.generateLog(test, "City :"+city);

			reportHelper.generateLog(test, "Remark :"+remark);
			try {

				genericHelper.sendKeysAndEnterWithjavascriptExecutor(cityMasterPage.country(), country);
				genericHelper.sendKeysAndEnterWithjavascriptExecutor(cityMasterPage.state(), state);

			} catch (Exception e) {
			
				reportHelper.generateLog(test, "Exception : "+e);
			}

			cityMasterPage.city().sendKeys("Nagpur");

			cityMasterPage.remark().sendKeys("Nagput city");

			reportHelper.generateLogWithScreenshot(test, "Before save");
			saveAndUpdateAction(test, commonFields.addBtn(), commonFields.cancelBtn(), expectedOutput);


		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}
		
		driver.navigate().refresh();
		String msg = "Record Inserted !!!";
		
		
		if (tostifyMessage.contains(msg))
		{
			String action = countryMasterPage.viewAction().getAttribute("class");
			
			reportHelper.performAssert(test, "Action", "edit", action);
			reportHelper.performAssert(test, "Sr no", "1", cityMasterPage.viewSrno().getText()); 
			reportHelper.performAssert(test, "County", country, cityMasterPage.viewCountry().getText());
			reportHelper.performAssert(test, "City", city, cityMasterPage.viewCity().getText());			
			reportHelper.performAssert(test, "Status", "Active", cityMasterPage.viewStatus().getText());
			reportHelper.performAssert(test, "Created By", createdBy, cityMasterPage.viewCreatedBy().getText());
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
	public void editCity(MasterDto masterDto) throws InterruptedException, IOException
	{
		navigateToPage.cityMasterPage();
		reportHelper.generateLogWithScreenshot(test, "State Master page");

		try {

			String searchCity = masterDto.getAttributeValue("Search City");

			String country = masterDto.getAttributeValue("Country");
			String state = masterDto.getAttributeValue("State");
			String city = masterDto.getAttributeValue("City");
			String remark = masterDto.getAttributeValue("Remark");

			String expectedOutput = masterDto.getAttributeValue("Expected Output");
			String status = masterDto.getAttributeValue("Status");


			test = reportHelper.createTestCase(test, extentReports, masterDto);

			searchData(searchCity);

			String cityName = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[3]/div")).getText();


			if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')])")).isDisplayed()) {

				reportHelper.performAssert(test, "State name", searchCity, cityName);

				if (searchCity.equalsIgnoreCase(cityName)) 
				{
					cityMasterPage.editBtn().click();

					if (country != null && !country.isEmpty()) {

						genericHelper.sendKeysAndEnterWithjavascriptExecutor(cityMasterPage.country(), country);
					}

					if (state != null && !state.isEmpty()) {

						genericHelper.sendKeysAndEnterWithjavascriptExecutor(cityMasterPage.state(), state);
					}

					if (city != null && !city.isEmpty()) {
						cityMasterPage.city().clear();
						cityMasterPage.city().sendKeys(city);
					}

					if (remark != null && !remark.isEmpty()) {

						cityMasterPage.remark().clear();
						cityMasterPage.remark().sendKeys(remark);
					}

					if (status != null && !status.isEmpty()) {

						statusSelection(cityMasterPage.activeStatus(), cityMasterPage.deactiveStatus(), status);

					}
					reportHelper.generateLogFullScreenSS(test, "Before Save");

					saveAndUpdateAction(test, commonFields.updateBtn(), commonFields.cancelBtn(), expectedOutput);

					
					driver.navigate().refresh();
					String msg ="Record Updated !!!";
					
					
					if (tostifyMessage.contains(msg))
					{
						String action = countryMasterPage.viewAction().getAttribute("class");
						
						reportHelper.performAssert(test, "Action", "edit", action);
						reportHelper.performAssert(test, "Sr no", "1", cityMasterPage.viewSrno().getText()); 
						reportHelper.performAssert(test, "County", country, cityMasterPage.viewCountry().getText());
						reportHelper.performAssert(test, "City", city, cityMasterPage.viewCity().getText());			
						reportHelper.performAssert(test, "Status", "Active", cityMasterPage.viewStatus().getText());
						reportHelper.performAssert(test, "Updated By", updatedBy, cityMasterPage.viewUpdatedBy().getText());
						String updatedAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
						if(countryMasterPage.viewUpdatedAt().getText().contains(msg))  
						{ 
						reportHelper.performAssert(test, "Updated At", updatedAt, countryMasterPage.viewCreatedAt().getText());
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
		cityMasterPage.updateBtn().click();
	}

	@Test
	public void gridViewCIty(MasterDto masterDto) throws Exception 
	{
		navigateToPage.cityMasterPage();
		Thread.sleep(1000);

		String expectedCity = masterDto.getAttributeValue("City");

		String expectedCountry = masterDto.getAttributeValue("Country");

		String searchCity = masterDto.getAttributeValue("Search City");
		String expectedState = StringUtils.defaultIfBlank(masterDto.getAttributeValue("State"), "");
		//masterDto.getAttributeValue("State");

		//state = genericHelper.handleNullString(state);

		//		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String expectedStatus = masterDto.getAttributeValue("Status");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		//	String searchState, String expectedState, String expectedCountry, String expectedStatus

		searchData(searchCity);

		String cityName = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[3]/div")).getText();


		if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')])")).isDisplayed()) {

			if (searchCity.equalsIgnoreCase(cityName)) 
			{
				//		stateMasterPage.searchBar().sendKeys(searchState);
				//		Thread.sleep(1000);
				//		commonFields.searchBtn().click();
				Thread.sleep(1000);

				String actualCity = cityMasterPage.viewCity().getText();

				String actualState = cityMasterPage.viewState().getText();
				String actualCountry = cityMasterPage.viewCountry().getText();
				String actualStatus = cityMasterPage.viewStatus().getText();
				String actualCreatedBy = cityMasterPage.viewCreatedBy().getText();
				String actualCreatedAt = cityMasterPage.viewCreatedAt().getText();
				String actualUpdatedAt = cityMasterPage.viewUpdatedAt().getText();
				String actualUpdatedBy = cityMasterPage.viewUpdatedBy().getText();

				Thread.sleep(1000);
				reportHelper.performAssert(test, "City", expectedCity, actualCity);

				reportHelper.performAssert(test, "State", expectedState, actualState);
				//genericHelper.compareStrings(expectedState, actualState);
				reportHelper.performAssert(test, "Country", expectedCountry, actualCountry);
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
				reportHelper.generateLog(test, "Updated At : "+actualUpdatedAt);

				
				reportHelper.generateLog(test, "Expected Output : "+expectedOutput);
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

	}
