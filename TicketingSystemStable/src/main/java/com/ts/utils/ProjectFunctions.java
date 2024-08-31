package com.ts.utils;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.sharedutils.ExcelHelper;
import com.sharedutils.GenericHelper;
import com.sharedutils.MasterDto;
import com.sharedutils.PropertyHelper;
import com.sharedutils.ReportsHelper;
import com.sharedutils.ScreenShotHelper;
import com.ts.core.*;
import com.ts.pagelayer.*;

public class ProjectFunctions implements ProjectConstants {

	public GenericHelper genericHelper = new GenericHelper();
	public ExcelHelper excelHelper = new ExcelHelper(); 
	public PropertyHelper propertyHelper = new PropertyHelper();
	public ReportsHelper reportHelper = new ReportsHelper();
	public ScreenShotHelper ssHelper = new ScreenShotHelper();
	public static MasterDto masterDto = new MasterDto();

	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static WebDriver driver;
	public static XSSFSheet sheet;
	public SoftAssert softAssert = new SoftAssert();

	protected static boolean isLoggedIn = false;

	//	public static CountryMasterPage countryMasterPage;

	//username
	protected static String username;

	//full Name
	protected static String createdBy;
	protected static String updatedBy;

	protected static String tostifyMessage;


	//Pom Page
	public static LoginPage loginPage;
	public static CountryMasterPage countryMasterPage;
	public static StateMasterPage stateMasterPage;
	public static CityMasterPage cityMasterPage;
	public static HomePage homePage;
	public static CommonFields commonFields;
	public static NavigateToPage navigateToPage;
	public static CustomerMasterPage customerMasterPage;
	public static UserMasterPage userMasterPage;
	public static DepartmentMasterPage departmentMasterPage;

	
	//Core Pages
	public static CountryMaster countryMaster;
	public static StateMaster stateMaster;
	public static CustomerMaster customerMaster;
	public static CityMaster cityMaster;
	public static UserMaster userMaster;
	public static DepartmentMaster departmentMaster;


	//Other
	public static JavascriptExecutor javascriptExecutor;
	public static WebDriverWait wait;

	public void pageInitialiazation(WebDriver driver) {

		//Pom Pages
		homePage = new HomePage(driver);
		commonFields = new CommonFields();
		loginPage = new LoginPage();
		countryMasterPage = new CountryMasterPage();
		navigateToPage = new NavigateToPage();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cityMasterPage = new CityMasterPage();
		stateMasterPage = new StateMasterPage();
		customerMasterPage = new CustomerMasterPage();
		userMasterPage = new UserMasterPage();		
		departmentMasterPage = new DepartmentMasterPage();

		//Core pages
		countryMaster = new CountryMaster();
		stateMaster = new StateMaster();
		cityMaster = new CityMaster();
		customerMaster = new CustomerMaster();
		userMaster = new UserMaster();		
		departmentMaster = new DepartmentMaster();

	}

	public void loginPage(WebDriver driver, String uname, String password) throws InterruptedException, Exception {

		username = uname;

		if (!isLoggedIn) {


			genericHelper.insertDataIntoField(loginPage.username(), uname);
			genericHelper.insertDataIntoField(loginPage.password(), password);

			Thread.sleep(1500);
			loginPage.signinBtn().click();



			try {
				if(commonFields.toastifyMsg().isDisplayed())
				{
					String msg = driver.findElement(By.xpath("//div[@class='Toastify__toast-body' and @role='alert']/div"))
							.getText();
					test.fail(msg);
					test.fail("<b>User Name : " + uname + "<br />Password : " + password + "<b/>");

					reportHelper.generateLog(test, "");
				}

				// onTestFailure("Uname : " +username+ " Password : "+password+ " : "+msg);
			} catch (Exception e) {

				test.pass("<b>User Name : " + uname + "<br />Password : " + password + "<b/>");
				reportHelper.onTestSuccess(test, "");

				isLoggedIn = true;


			}

		}
	}

	//	public void loginPage(WebDriver driver) throws InterruptedException, Exception, IOException
	//
	//	{
	//		WebElement username = driver.findElement(By.id("email_id"));
	//
	//		username.clear();
	//		Thread.sleep(1000);
	//
	//		username.sendKeys(propertyHelper.readDataFromPropertyFile(GlobalConstants.CONFIG_FILE, "Uname"));
	//		Thread.sleep(2500);
	//
	//		WebElement pwd = driver.findElement(By.id("password"));
	//		pwd.clear();
	//		Thread.sleep(1000);
	//
	//		pwd.sendKeys(propertyHelper.readDataFromPropertyFile(GlobalConstants.CONFIG_FILE, "pwd"));
	//		Thread.sleep(2500);
	//
	//		test.info("<b>Uname : " + propertyHelper.readDataFromPropertyFile(GlobalConstants.CONFIG_FILE, "Uname")
	//		+ "<br />Password : " + propertyHelper.readDataFromPropertyFile(GlobalConstants.CONFIG_FILE, "pwd")
	//		+ "<b/>");
	//
	//		driver.findElement(By.xpath("//button[text()='SIGN IN']")).click();
	//		Thread.sleep(3000);
	//
	//		reportHelper.onTestSuccess(test, "<b>Logged in successfully<b/>");
	//	}

	public void logoutPage(WebDriver driver) throws InterruptedException, Exception {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(50));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//img[@alt='profile'])[1]"))));
		Thread.sleep(2500);

		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

		driver.findElement(By.xpath("(//img[@alt='profile'])[1]")).click();
		Thread.sleep(2500);

		driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
		Thread.sleep(2500);

		reportHelper.onTestSuccess(test, "<b>Logged Out successfully<b/>");
	}

	public void saveAndUpdateAction(ExtentTest test, WebElement saveBtn, WebElement cancelBtn, String expectedOutput) throws IOException, InterruptedException
	{
		try {
			Assert.assertTrue(saveBtn.isEnabled());
			saveBtn.click();

			Thread.sleep(1000);
			String msg = commonFields.toastifyMsg().getText();
			tostifyMessage = msg;
			Thread.sleep(1000);

			System.out.println("Toast msg : "+msg+" expected output : "+expectedOutput);

			if (commonFields.toastifyMsg().isDisplayed() && msg.toLowerCase().contains(expectedOutput.toLowerCase())) 
			{
				reportHelper.onTestSuccess(test, msg);
				reportHelper.generateLogFullScreenSS(test,commonFields.toastifyMsg().getText());
				if (commonFields.toastifyCloseBtn().isDisplayed()) {
					commonFields.toastifyCloseBtn().click();
				}
			}
			else if (commonFields.toastifyMsg().isDisplayed()) 
			{	
				Thread.sleep(1500);
				// System.out.println("in loop :"+msg);
				//Thread.sleep(1500);

				reportHelper.onTestFailure(test, msg);
				Thread.sleep(1500);
				reportHelper.generateLogFullScreenSS(test, "Error");

				if (commonFields.toastifyCloseBtn().isDisplayed()) {
					commonFields.toastifyCloseBtn().click();
				}

			}
		} 
		catch (Exception e) 
		{
			if (cancelBtn.isDisplayed()) {
				reportHelper.onTestSuccess(test, "Test case pass : "+expectedOutput);
			}
			else
			{
				reportHelper.onTestFailure(test, "Test case fail : "+expectedOutput);
				reportHelper.generateLogFullScreenSS(test, "");

				genericHelper.clickWithjavascriptExecutor(cancelBtn);
			}
		}

		try {
			if(cancelBtn.isDisplayed())
			{
				cancelBtn.click();
				//Assert.assertTrue(false);
			}				
		} catch (Exception e) {
			reportHelper.generateLog(test, "Exception : "+e);
		}
	}

	public void statusSelection(WebElement activeStatus, WebElement deactiveStatus, String status)
	{
		if(status.equalsIgnoreCase("active"))
		{
			activeStatus.click();
		}

		else if (status.equalsIgnoreCase("deactive")) {
			deactiveStatus.click();
		}
	}

	public void searchData(String search) throws InterruptedException, IOException
	{

		commonFields.resetBtn().click();

		genericHelper.insertDataIntoField(commonFields.search(), search);

		commonFields.searchBtn().click();

		reportHelper.generateLogWithScreenshot(test, "Search result");

	}

}
