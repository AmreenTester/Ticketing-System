package com.ts.testlayer;

import java.util.Map;

import org.testng.annotations.Test;

import com.ts.utils.MasterClass;

public class TestCountryMaster extends MasterClass 
{
	@Test(priority = 10)
	public void addCountry() throws InterruptedException, Exception {
		loginPage(driver, "amreens", "12345678");
		createdBy = "Amreen Shaikh";
		
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(dataPath + countryMasterSheet, "Add"); rowIndex++) {

			// countryMasterPage.addCountry().click();
 
			Map<String, String> rowData = excelHelper.readExcelDataAndMap(dataPath + countryMasterSheet, "Add", rowIndex);

			for (Map.Entry<String, String> entry : rowData.entrySet())
			{
				masterDto.setAttribute(entry.getKey(), entry.getValue());
			}

			countryMaster.addCounty(masterDto);
		}
	}

	//@Test(priority = 20)
	public void editCountry() throws Exception, Throwable {
		loginPage(driver, "amreens", "12345678");
		updatedBy = "Amreen Shaikh";
		
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(dataPath + countryMasterSheet, "Edit"); rowIndex++) {

			// countryMasterPage.addCountry().click();

			Map<String, String> rowData = excelHelper.readExcelDataAndMap(dataPath + countryMasterSheet, "Edit", rowIndex);

			for (Map.Entry<String, String> entry : rowData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());

			}

			countryMaster.editCounty(masterDto);
		}
	}

//	@Test(priority = 30)
	public void viewCountry() throws InterruptedException, Exception 
	{

		loginPage(driver, "amreens", "12345678");
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel(dataPath + countryMasterSheet, "View"); rowIndex++) {

			// countryMasterPage.addCountry().click();

			Map<String, String> rowData = excelHelper.readExcelDataAndMap(dataPath + countryMasterSheet, "View", rowIndex);

			for (Map.Entry<String, String> entry : rowData.entrySet()) {

				masterDto.setAttribute(entry.getKey(), entry.getValue());

			}

			countryMaster.gridViewCounty(masterDto);
		}

	}

}
