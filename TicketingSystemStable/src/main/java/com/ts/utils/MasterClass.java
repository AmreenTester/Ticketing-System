package com.ts.utils;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sharedutils.*;


public class MasterClass extends ProjectFunctions
{	 

	@BeforeSuite
	public void preSuiteHandler() throws Exception 
	{
		masterDto.setAttribute("reportName", qaName);
		masterDto.setAttribute("docTitle", docTitle);
		masterDto.setAttribute("reportName", reportName);		
	 
		extentReports = reportHelper.generateReport(masterDto); 
		test=extentReports.createTest("Setup");	
		
		String browser = "chrome"; 
		driver = genericHelper.startBrowser(test, browser);

		String url = propertyHelper.readDataFromPropertyFile(GlobalConstants.CONFIG_FILE, "2TestingURL");

		genericHelper.navigateToURL(test, url); 

		pageInitialiazation(driver);

	} 

	@AfterMethod
	public void postMethodHandler(ITestResult result) throws IOException, Exception 
	{
		reportHelper.tearDown(test, result);
		extentReports.flush();
	}
	
	@AfterSuite
	public void postSuiteHandler() throws IOException, Exception 
	{
		isLoggedIn = false;
	}
	


}
