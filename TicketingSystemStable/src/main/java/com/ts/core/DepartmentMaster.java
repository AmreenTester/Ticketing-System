package com.ts.core;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ts.pagelayer.DepartmentMasterPage;
import com.ts.utils.MasterClass;

public class DepartmentMaster extends MasterClass {


	@Test
	public void addDepartment() throws InterruptedException, Exception
	{	
		navigateToPage.departmentMasterPage();

		//String departmentName = "Audit Team asd";
		//	String Remark = "Good Language";

		//String country = masterDto.getAttributeValue("Country");
		String departmentName = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Department Name"), "");

		String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
		//		remark = genericHelper.handleNullString(remark);
		String expectedOutput = masterDto.getAttributeValue("Expected Output");

		test = reportHelper.createTestCase(test, extentReports, masterDto);
		reportHelper.generateLogWithScreenshot(test, "Department Master page");

		//dto.getAttribute(billCheckingTransactionSheet)
		try {


			Thread.sleep(1500);
			departmentMasterPage.addDepartment().click();

			reportHelper.generateLogWithScreenshot(test, "Departmetn add page");
			reportHelper.generateLog(test, "Department :"+departmentName);
			reportHelper.generateLog(test, "Remark :"+remark);


			departmentMasterPage.departemntName().sendKeys(departmentName);
			Thread.sleep(1500);
			departmentMasterPage.deptRemark().sendKeys(remark);
			Thread.sleep(1500);

			saveAndUpdateAction(test, commonFields.addBtn(), commonFields.cancelBtn(), expectedOutput);

			driver.navigate().refresh();
			String msg = "Record Inserted !!!";


			if (tostifyMessage.contains(msg))
			{
				String action = countryMasterPage.viewAction().getAttribute("class");

				reportHelper.performAssert(test, "Action", "edit", action);
				reportHelper.performAssert(test, "Sr no", "1", stateMasterPage.viewSrno().getText()); 
//				reportHelper.performAssert(test, "County", country, stateMasterPage.viewCountry().getText());
//				reportHelper.performAssert(test, "State", state, stateMasterPage.viewState().getText());

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

			//		departmentMasterPage.submit().click();
			//departmentMaster.cancel().click();

		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}


	}

	@Test
	public void editdepartment() throws InterruptedException, Exception
	{
		// Login with credentials

		// Navigate to Customer Master page
		navigateToPage.departmentMasterPage();

		try {

			String searchDepartment = masterDto.getAttributeValue("Search Department");

			String department = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Department Name"), "");

			String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");
			//		remark = genericHelper.handleNullString(remark);
			String expectedOutput = masterDto.getAttributeValue("Expected Output");
			String status = masterDto.getAttributeValue("Status");

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			reportHelper.generateLogWithScreenshot(test, "Department Master page");


			// Search for the customer by name
			searchData(searchDepartment);

			String departmentName = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[3]/div")).getText();

			if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')])")).isDisplayed()) {

				reportHelper.performAssert(test, "Department name", searchDepartment, departmentName);

				if (searchDepartment.equalsIgnoreCase(departmentName)) 
				{

					departmentMasterPage.editBtn().click();

					// Define customer information to be updated


					// Update customer details
					// genericHelper.insertDataIntoField(customerMasterPage.customerId(), customerType);
					//customerMasterPage.customerName().sendKeys(customerName);
					//Thread.sleep(1500);
					if (department != null && !department.isEmpty()) {

						genericHelper.clearAndSendKeysWithjavascriptExecutor(departmentMasterPage.departemntName(),department);
						Thread.sleep(1500);
					}

					if (remark != null && !remark.isEmpty()) {
						genericHelper.clearAndSendKeysWithjavascriptExecutor(departmentMasterPage.deptRemark(),remark);
						Thread.sleep(1500);
					}

					if (status != null && !status.isEmpty()) {

						statusSelection(stateMasterPage.activeStatus(), stateMasterPage.deactiveStatus(), status);
					}
					// Submit the updated information
					//	departmentMasterPage.update().click();
					saveAndUpdateAction(test, commonFields.updateBtn(), commonFields.cancelBtn(), expectedOutput);
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
	public void gridViewDepartmentMaster() throws Exception 
	{
		
		navigateToPage.departmentMasterPage();
		Thread.sleep(1000);
		
		String expectedDepartment = masterDto.getAttributeValue("Department");
		String expectedStatus = masterDto.getAttributeValue("Status");
		String searchDepartment = masterDto.getAttributeValue("Search Department");
		String expectedOutput = masterDto.getAttributeValue("Expected Output");

		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "Department Master page");

		searchData(searchDepartment);
				
		String actualDepartment = departmentMasterPage.viewDepartment().getText();
		String actualStatus = departmentMasterPage.viewStatus().getText();

		Thread.sleep(1000);
		
		reportHelper.performAssert(test, "Department", expectedDepartment, actualDepartment);

//		genericHelper.compareStrings(expectedDepartment, expectedDepartment);
	
		reportHelper.performAssert(test, "Status", expectedStatus, actualStatus);

		//genericHelper.compareStrings(expectedStatus, actualStatus);
		reportHelper.generateLog(test, "Expected Output : "+expectedOutput);

		
	}
}
