package com.ts.core;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.sharedutils.MasterDto;
import com.sharedutils.ReportsHelper;

import org.apache.commons.lang3.StringUtils;

import com.ts.utils.MasterClass;


public class UserMaster extends MasterClass
{
/*
	public void editUser(MasterDto masterDto) throws InterruptedException
	{
		//String accountFor, String firstName,String middleName,String lastName,String emailAddress,String userName ,String contactNumber,String whatsApp,String Passward,String confirmPass,String role,String designation,String addr,String pincode,String country,String state,String city
		navigateToPage.userMasterPage();
		
		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "User Master page");

		try {
			
		String accountFor = masterDto.getAttributeValue("Accoutn For");
		String selectCustomer = masterDto.getAttributeValue("Select Customer");
		String first_Name = masterDto.getAttributeValue("First Name");
		String middle_Name = masterDto.getAttributeValue("Middle Name");
		String last_Name = masterDto.getAttributeValue("Last Name");
		String emailId = masterDto.getAttributeValue("Email id");
		String userName = masterDto.getAttributeValue("User Name");
		String contactNo = masterDto.getAttributeValue("Contact No");
		String samecontactNo = masterDto.getAttributeValue("Same Contact No");
		String whatsappContactNo = masterDto.getAttributeValue("Whatsapp Contact No");
		String password = masterDto.getAttributeValue("Password");
		String confirmPassword = masterDto.getAttributeValue("Confirm Password");
		String role = masterDto.getAttributeValue("Role");
		String designation = masterDto.getAttributeValue("Designation");
		String address = masterDto.getAttributeValue("Address");
		String pincode = masterDto.getAttributeValue("Pincode");
		String country = masterDto.getAttributeValue("Country");
		String state = masterDto.getAttributeValue("State");
		String city = masterDto.getAttributeValue("City");
		String expectedOutput = masterDto.getAttributeValue("Expected Output");

		
		userMasterPage.searchBar().sendKeys("Prashant Krishna Dixit");
		commonFields.searchBtn().click();
		userMasterPage.editButton().click();
		userMasterPage.accountFor().sendKeys(accountFor);
		userMasterPage.firstName().sendKeys(firstName);
		userMasterPage.middleName().sendKeys(middleName);
		userMasterPage.lastName().sendKeys(lastName);
		userMasterPage.emailAddress().sendKeys(emailAddress);
		userMasterPage.username().sendKeys(userName);
		userMasterPage.contactNumber().sendKeys(contactNumber);
		userMasterPage.whatsappNumber().sendKeys(whatsApp);
		userMasterPage.password().sendKeys(Passward);
		userMasterPage.confirmPassword().sendKeys(confirmPass);

		//genericHelper.insertDataIntoField(usermasterpage.selectRole(), role);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.selectRole(), role);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.selectDesignation(), designation);
		genericHelper.ClearAndsendKeysAndEnter(userMasterPage.selectRole(), role);

		userMasterPage.address().sendKeys(addr);
		userMasterPage.pincode().sendKeys(pincode);

		genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.country(), country);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.state(), state);
		//usermasterpage.state().sendKeys(state,Keys.ENTER);

		Thread.sleep(2000);
		genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.city(), city);
		//genericHelper.scrollingTillWebElement(usermasterpage.commonFields.nextBtn());
		//usermasterpage.commonFields.nextBtn().click();
		genericHelper.clickWithjavascriptExecutor(commonFields.nextBtn());
		userMasterPage.ticketPassingAuthorityButton().click();
		userMasterPage.makeDefaultButton().click();
		//usermasterpage.commonFields.submitBtn();
		genericHelper.clickWithjavascriptExecutor(commonFields.submitBtn());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	*/

	//@Test
	public void gridViewUserMaster(MasterDto masterDto) throws Exception 
	{

		//String searchuser, String expectedcustomer,String name,String username, String expectedStatus
		navigateToPage.userMasterPage();
		Thread.sleep(1000);
		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogFullScreenSS(test, "User master page");

		String searchUser = masterDto.getAttributeValue("Search");
		String expectedOutput = masterDto.getAttributeValue("Expected Output");
		String accountFor = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Accoutn For"), "");
		String customer = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Customer"), "");
		String emailid = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Email Id"), "");
		String contactNo = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Contact No"), "");

		
		//	String searchuser = StringUtils.defaultIfBlank(masterDto.getAttributeValue(""),"");  
		String expectedcustomer = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Customer"),"");  
		String name = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Name"),"");  
		String username = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Username"),""); 
		String expectedStatus = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Status"),""); 
		
		
		searchData(searchUser);

		String userName1 = driver.findElement(By.xpath("//div[contains(@class,'TableRow')]/div[5]/div")).getText();

		if (driver.findElement(By.xpath("//div[contains(@class,'TableRow')])")).isDisplayed()) 
		{
				
			if (username.equalsIgnoreCase(userName1)) 
			{
				reportHelper.performAssert(test, "Account for", accountFor, userMasterPage.viewAccount().getText());
				reportHelper.performAssert(test, "Customer", customer, userMasterPage.viewCustomer().getText());
				reportHelper.performAssert(test, "Name",name , userMasterPage.viewName().getText());

				reportHelper.performAssert(test, "Email id", emailid, userMasterPage.viewEmail().getText());
				reportHelper.performAssert(test, "Contact No", contactNo, userMasterPage.viewContactNo().getText());
				reportHelper.performAssert(test, "Username", username, userMasterPage.viewUsername().getText());

				reportHelper.performAssert(test, "Status", "Active", userMasterPage.viewStatus().getText());
				//reportHelper.performAssert(test, "Created By", createdBy, userMasterPage.viewCreatedBy().getText());
//				String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
//				if(userMasterPage.viewCreatedAt().getText().contains(createdAt))  
//				{ 
//					reportHelper.performAssert(test, "Created At", createdAt, userMasterPage.viewCreatedAt().getText());
//				}
				
				String UpdatedAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(userMasterPage.viewUpdatedAt().getText().contains(UpdatedAt))  
				{ 
					reportHelper.performAssert(test, "Updated At", UpdatedAt, userMasterPage.viewUpdatedAt().getText());
				}
				
				reportHelper.performAssert(test, "User name", searchUser, userName1);

				//genericHelper.clickWithjavascriptExecutor(usermaster.commonFields.searchBtn());
				String actualcustomer = userMasterPage.viewCustomer().getText();
				String actualStatusname = userMasterPage.viewName().getText();
				String actualStatususername = userMasterPage.viewUsername().getText();
				String actualStatusstatus = userMasterPage.viewStatus().getText();
				String actualCreatedBy = userMasterPage.viewCreatedBy().getText();
				String actualCreatedAt = userMasterPage.viewCreatedAt().getText();

				String actualUpdatedBy = userMasterPage.viewUpdatedBy().getText();
				String actualUpdatedAt = userMasterPage.viewUpdatedAt().getText();

				
				Thread.sleep(1000);

//				reportHelper.performAssert(test, "Account for", accountFor, userMasterPage.viewAccount().getText());
//				reportHelper.performAssert(test, "Customer", customer, userMasterPage.viewCustomer().getText());
//				reportHelper.performAssert(test, "Name",name , userMasterPage.viewName().getText());
//
//				reportHelper.performAssert(test, "Email id", emailid, userMasterPage.viewEmail().getText());
//				reportHelper.performAssert(test, "Contact No", contactNo, userMasterPage.viewContactNo().getText());
//				reportHelper.performAssert(test, "Username", username, userMasterPage.viewUsername().getText());

				//reportHelper.performAssert(test, "Status", "Active", userMasterPage.viewStatus().getText());
			
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
		}
		else 
		{
			reportHelper.generateLog(test, "No data found");
			reportHelper.generateLog(test, "Expected output : "+expectedOutput);
		}
	}



	@Test(priority = 20, enabled = true)
	public void addUser(MasterDto masterDto) throws Throwable, Exception, Exception
	{
		//		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		//		String testname = className + " :: "+methodName;
		//		createTest(testname,"");		

		//WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		//	UserMasterPage userMasterPage= new UserMasterPage(driver);

		navigateToPage.userMasterPage();

		//String remark = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Remark"), "");


		String accountFor = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Accoutn For"), "");
		String selectCustomer = masterDto.getAttributeValue("Select Customer");
		String first_Name = StringUtils.defaultIfBlank(masterDto.getAttributeValue("First Name"),"");
		String middle_Name = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Middle Name"),"");
		String last_Name = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Last Name"),"");
		String emailId = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Email id"),"");
		String userName = StringUtils.defaultIfBlank(masterDto.getAttributeValue("User Name"),"");
		String contactNo = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Contact No"),"");
		String samecontactNo = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Same Contact No"),"");
		String whatsappContactNo = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Whatsapp Contact No"),"");
		String password = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Password"),"");
		String confirmPassword = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Confirm Password"),"");
		String role = masterDto.getAttributeValue("Role");
		String designation = masterDto.getAttributeValue("Designation");
		String address = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Address"),"");
		String pincode = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Pincode"),"");
		String country = masterDto.getAttributeValue("Country");
		String state = masterDto.getAttributeValue("State");
		String city = masterDto.getAttributeValue("City");
		String expectedOutput = masterDto.getAttributeValue("Expected Output");

		String department = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Department"),"");
		String ticketTypeShow = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Ticket Type Show"),"");
		String ticketPassingAuthority = StringUtils.defaultIfBlank(masterDto.getAttributeValue("Ticket Passing Authority"),"");
		String makeDefault = StringUtils.defaultIfBlank(masterDto.getAttributeValue("MakeDefault"),"");


		test = reportHelper.createTestCase(test, extentReports, masterDto);

		reportHelper.generateLogWithScreenshot(test, "User Master page");

		try {

			userMasterPage.addUser().click();
			reportHelper.generateLog(test, "Account For :"+accountFor);
			reportHelper.generateLog(test, "Select customer :"+selectCustomer);
			reportHelper.generateLog(test, "First name :"+first_Name);
			reportHelper.generateLog(test, "Middle name :"+middle_Name);
			reportHelper.generateLog(test, "Last name :"+last_Name);
			reportHelper.generateLog(test, "Email id :"+emailId);
			reportHelper.generateLog(test, "User name :"+userName);
			reportHelper.generateLog(test, "Contact no :"+contactNo);
			reportHelper.generateLog(test, "Same contact no :"+samecontactNo);
			reportHelper.generateLog(test, "Whatsapp no :"+whatsappContactNo);
			reportHelper.generateLog(test, "Password :"+password);
			reportHelper.generateLog(test, "Confirm password :"+confirmPassword);
			reportHelper.generateLog(test, "Role :"+role);
			reportHelper.generateLog(test, "Designation :"+designation);
			reportHelper.generateLog(test, "Address :"+address);
			reportHelper.generateLog(test, "Pincode :"+pincode);

			reportHelper.generateLog(test, "Country :"+country);
			reportHelper.generateLog(test, "State :"+state);
			reportHelper.generateLog(test, "City :"+city);

			genericHelper.selectFromDropDownByVisibleText(userMasterPage.accountFor(), accountFor);
			if(accountFor.contains("CUSTOMER"))
			{
				userMasterPage.selectCustomer().sendKeys(selectCustomer);
			}

			//String accountFor, String selectCustomer, String first_Name, String middle_Name, String last_Name, String emailId, String userName, String contactNo, String samecontactNo, String whatsappContactNo, String password, String confirmPassword, String role, String designation, String address, String pincode, String country, String state,String city,  String department, String ticketTypeShow, String ticketPassingAuthority, String makeDefault;

			Thread.sleep(2000); 

			//			String first_Name = p.toReadDataFromExcel(n, sheetName, 1, i);
			//			String middle_Name = p.toReadDataFromExcel(n, sheetName, 2, i);
			//			Strign last_Name = p.toReadDataFromExcel(n, sheetName, 3, i);
			//			String emailId = p.toReadDataFromExcel(n, sheetName, 4, i);
			//			String userName = p.toReadDataFromExcel(n, sheetName, 5, i);
			//			String contactNo = p.toReadDataFromExcel(n, sheetName, 6, i);
			//			String samecontactNo = p.toReadDataFromExcel(n, sheetName, 7, i);
			//			String whatsappContactNo = p.toReadDataFromExcel(n, sheetName, 8, i);
			//			String password = p.toReadDataFromExcel(n, sheetName, 9, i);
			//			String confirmPassword = p.toReadDataFromExcel(n, sheetName, 9, i);
			//			String role = p.toReadDataFromExcel(n, sheetName, 10, i);
			//			String designation = p.toReadDataFromExcel(n, sheetName, 11, i);
			//			String address = p.toReadDataFromExcel(n, sheetName, 12, i);
			//			String pincode = p.toReadDataFromExcel(n, sheetName, 13, i);
			//			String country = p.toReadDataFromExcel(n, sheetName, 14, i);
			Thread.sleep(2000);


			userMasterPage.firstName().sendKeys(first_Name);
			Thread.sleep(2000);

			userMasterPage.middleName().sendKeys(middle_Name);
			Thread.sleep(2000);

			userMasterPage.lastName().sendKeys(last_Name);
			Thread.sleep(2000);

			userMasterPage.emailID().sendKeys(emailId);
			Thread.sleep(2000);

			userMasterPage.userName().sendKeys(userName);
			Thread.sleep(2000);

			userMasterPage.contactNo().sendKeys(contactNo);
			Thread.sleep(2000);


			if(samecontactNo.equalsIgnoreCase("yes"))
			{
				userMasterPage.sameAsContactNo().click();

				reportHelper.generateLogFullScreenSS(test,"Same as contact no");

				String no = userMasterPage.whatsappContactNo().getText();

				reportHelper.performAssert(test, "Whatsapp No", contactNo, no);


				//		onTestSuccess("Contact No : "+contactNo+ "\nWhatsApp No : "+no);
				//			

				//			if(userMasterPage.sameAsContactNo().isEnabled())
				//			{
				//				onTestFailure("WhatsApp no not disabled");
				//			}
				//			
				//			else
				//			{
				//				onTestSuccess("WhatsApp no is disabled");	
				//			}

			}

			else
			{
				userMasterPage.whatsappContactNo().sendKeys(whatsappContactNo);
				Thread.sleep(2000);
			}

			userMasterPage.password().sendKeys(password);
			Thread.sleep(2000);

			userMasterPage.confirmPassword().sendKeys(confirmPassword);
			Thread.sleep(2000);

			try {
				userMasterPage.role().sendKeys(role,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
				//userMasterPage.role().sendKeys(role,Keys.ENTER);
				Thread.sleep(2000); 
				//		Actions act = new Actions(driver);
				//		act.click(userMasterPage.role()).pause(10).sendKeys("Test").pause(10).sendKeys(Keys.ENTER).build().perform();

				userMasterPage.designation().sendKeys(designation,Keys.ENTER);
				Thread.sleep(2000); 

			} catch (Exception e) {

				reportHelper.generateLog(test, "Exception : "+e);
			}

			userMasterPage.address().sendKeys(address);
			Thread.sleep(2000);

			userMasterPage.pincode().sendKeys(pincode);  
			Thread.sleep(2000);

			try {

				userMasterPage.country().sendKeys(country,Keys.ENTER);
				Thread.sleep(2000);

				genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.state(), state);

				genericHelper.sendKeysAndEnterWithjavascriptExecutor(userMasterPage.city(), city);

			} catch (Exception e) {

				reportHelper.generateLog(test, "Exception : "+e);
			}


			reportHelper.generateLogFullScreenSS(test,"Data added");

			genericHelper.scrollingTillWebElement(userMasterPage.nextBtn());

			//	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", userMasterPage.nextBtn());


			Thread.sleep(2000); 
			Actions act = new Actions(driver);
			act.click(userMasterPage.nextBtn()).pause(10).build().perform();
			//		userMasterPage.nextBtn().click();

			////		String department = p.toReadDataFromExcel(n, sheetName, 17, i);
			//		String ticketTypeShow = p.toReadDataFromExcel(n, sheetName, 18, i);
			//		
			//		String ticketPassingAuthority = p.toReadDataFromExcel(n, sheetName, 19, i);
			//		String makeDefault = p.toReadDataFromExcel(n, sheetName, 20, i);


			userMasterPage.department().sendKeys(department,Keys.ENTER);
			Thread.sleep(2000); 

			userMasterPage.ticketShowType().sendKeys(ticketTypeShow,Keys.ENTER);
			Thread.sleep(2000);

			try {

				if(ticketPassingAuthority.equalsIgnoreCase("yes"))
				{
					userMasterPage.ticketPassingAuthority().click();	
				}

				else if (ticketPassingAuthority.equalsIgnoreCase("no")) 
				{

				}

			}

			catch (Exception e) {

			}

			try {

				if(makeDefault.equalsIgnoreCase("yes"))
				{
					userMasterPage.makeDefault().click();	
				}

				else if (makeDefault.equalsIgnoreCase("no")) 
				{

				}


			} catch (Exception e) {

			}

			//		try {	
			//
			//			String department2 = p.toReadDataFromExcel(n, sheetName, 21, i);
			//			String ticketTypeShow2 = p.toReadDataFromExcel(n, sheetName, 22, i);
			//
			//			userMasterPage.addDepartment().click();
			//			Thread.sleep(1500);				
			//
			//			userMasterPage.department().sendKeys(department2,Keys.ENTER);
			//			Thread.sleep(2000); 
			//
			//			userMasterPage.ticketShowType().sendKeys(ticketTypeShow2,Keys.ENTER);
			//			Thread.sleep(2000);
			//
			//			try 
			//			{
			//				String ticketPassingAuthority2 = p.toReadDataFromExcel(n, sheetName, 23, i);
			//				if(ticketPassingAuthority2.equalsIgnoreCase("yes"))
			//				{
			//					userMasterPage.ticketPassingAuthority().click();	
			//				}
			//
			//				else if (ticketPassingAuthority2.equalsIgnoreCase("no")) 
			//				{
			//
			//				}
			//
			//
			//			}
			//
			//			catch (Exception e) {
			//
			//			}
			//
			//			try {
			//				String makeDefault2 = p.toReadDataFromExcel(n, sheetName, 24, i);
			//
			//				if(makeDefault2.equalsIgnoreCase("yes"))
			//				{
			//					userMasterPage.makeDefault().click();	
			//				}
			//
			//				else if (makeDefault2.equalsIgnoreCase("no")) 
			//				{
			//
			//				}
			//
			//
			//			} catch (Exception e) {
			//
			//			}
			//
			//		} catch (Exception e) {
			//			// TODO: handle exception
			//		}
			//
			//
			//
			//		try 
			//		{
			//			String department3 = p.toReadDataFromExcel(n, sheetName, 25, i);
			//			String ticketTypeShow3 = p.toReadDataFromExcel(n, sheetName, 26, i);
			//
			//			userMasterPage.addDepartment().click();
			//			Thread.sleep(1500);				
			//
			//
			//			userMasterPage.department().sendKeys(department3,Keys.ENTER);
			//			Thread.sleep(2000); 
			//
			//			userMasterPage.ticketShowType().sendKeys(ticketTypeShow3,Keys.ENTER);
			//			Thread.sleep(2000);
			//
			//			try 
			//			{
			//				String ticketPassingAuthority3 = p.toReadDataFromExcel(n, sheetName, 27, i);
			//				if(ticketPassingAuthority3.equalsIgnoreCase("yes"))
			//				{
			//					userMasterPage.ticketPassingAuthority().click();	
			//				}
			//
			//				else if (ticketPassingAuthority3.equalsIgnoreCase("no")) 
			//				{
			//
			//				}
			//			}
			//
			//			catch (Exception e) {
			//
			//			}
			//
			//			try {
			//				String makeDefault3 = p.toReadDataFromExcel(n, sheetName, 28, i);
			//
			//				if(makeDefault3.equalsIgnoreCase("yes"))
			//				{
			//					userMasterPage.makeDefault().click();	
			//				}
			//
			//				else if (makeDefault3.equalsIgnoreCase("no")) 
			//				{
			//
			//				}
			//
			//			} catch (Exception e) {
			//
			//			}
			//
			//		} catch (Exception e)
			//		{
			//			// TODO: handle exception
			//		}


			//			reportHelper.generateLogFullScreenSS(test, "Data added for "+userName);
			Thread.sleep(2000);

			reportHelper.generateLogFullScreenSS(test, "Before save");

			saveAndUpdateAction(test, commonFields.submitBtn(), commonFields.cancelBtn(), expectedOutput);

			driver.navigate().refresh();
			String msg = "Record Inserted !!!";

			String name = first_Name + " " +middle_Name+" "+last_Name; 
			
			if (tostifyMessage.contains(msg))
			{
				
				String action = userMasterPage.viewAction().getAttribute("class");

				reportHelper.performAssert(test, "Action", "edit", action);
				reportHelper.performAssert(test, "Sr no", "1", userMasterPage.viewSrno().getText()); 
				reportHelper.performAssert(test, "Account for", accountFor, userMasterPage.viewAccount().getText());
				reportHelper.performAssert(test, "Customer", selectCustomer, userMasterPage.viewCustomer().getText());
				reportHelper.performAssert(test, "Name",name , userMasterPage.viewName().getText());

				reportHelper.performAssert(test, "Email id", emailId, userMasterPage.viewEmail().getText());
				reportHelper.performAssert(test, "Contact No", contactNo, userMasterPage.viewContactNo().getText());
				reportHelper.performAssert(test, "Username", userName, userMasterPage.viewUsername().getText());

				reportHelper.performAssert(test, "Status", "Active", userMasterPage.viewStatus().getText());
				reportHelper.performAssert(test, "Created By", createdBy, userMasterPage.viewCreatedBy().getText());
				String createdAt = genericHelper.getCurrentDateTimeToField("yyyy-MM-dd HH:mm");
				if(userMasterPage.viewCreatedAt().getText().contains(createdAt))  
				{ 
					reportHelper.performAssert(test, "Created At", createdAt, userMasterPage.viewCreatedAt().getText());
				}
			}
			else 
			{
				//				reportHelper.generateLog(test, "No data found");
				//				reportHelper.generateLog(test, "Expected output : "+expectedOutput);
			}

			//			commonFields.submitBtn().click();
			//			Thread.sleep(20000);

		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	//	public void addUser(String accountFor, String selectCustomer, String first_Name, String middle_Name, String last_Name, String emailId, String userName, String contactNo, String samecontactNo, String whatsappContactNo, String password, String confirmPassword, String role, String designation, String address, String pincode, String country, String state,String city,  String department, String ticketTypeShow, String ticketPassingAuthority, String makeDefault ) throws Throwable, Exception, Exception
	//	{
	//	}
}