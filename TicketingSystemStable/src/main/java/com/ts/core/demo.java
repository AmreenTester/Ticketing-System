package com.ts.core;

import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class demo {
	
	public void editBill() throws Exception
	{
		//		String methodName = new Throwable().getStackTrace()[0].getMethodName();
		//		//String testname = className + " :: "+methodName; 
		//		createTest(methodName,"Add transaction");	 

		//	HomePage hp = new HomePage(driver);

		navigateToPage.billCheckingTransactionPage();
		

		//		commonFields.search().sendKeys(billNo);
		//		Thread.sleep(3000);
		//		
		//		commonFields.searchBtn().click();
		//		Thread.sleep(3000);

		//		List<WebElement> ele = driver.findElements(By.xpath("//div[text()='"+billNo+"']//parent::div//parent::div/div/div/ul/li"));
		//		int ele1 = ele.size();
		//		
		//		for (int i = 1; i <=ele1; i++) 
		//		{
		//			
		//			String act = driver.findElement(By.xpath("//div[text()='"+billNo+"']//parent::div//parent::div/div/div/ul/li["+ele1+"]/a")).getText();
		//			 
		//			generateLogWithSS("Acctions being displayed to assigned to person login : "+act);
		//	
		//		}

		reportHelper.generateLogFullScreenSS(test, "Bill transaction page");


		System.out.println("In for");
		for (int rowIndex = 1; rowIndex <= excelHelper.rowCountExcel("./public/data/BillCheckingTransaction.xlsx","Add"); rowIndex++)
		{
			Map<String, String> rowData = excelHelper.readExcelDataAndMap("./public/data/BillCheckingTransaction.xlsx", "Add", rowIndex);

			for (Map.Entry<String, String> entry : rowData.entrySet()) 
			{
				//System.out.println("In Map");
				masterDto.setAttribute(entry.getKey(), entry.getValue());

			}

			test = reportHelper.createTestCase(test, extentReports, masterDto);

			//				billCheckingTransactionPage.billType().isEnabled();
			//				billCheckingTransactionPage.billType().getAttribute("");

			String billType=(String) masterDto.getAttributeValue("Bill Type");
			String assignTo = masterDto.getAttributeValue("Assign To");
			String VendorName = masterDto.getAttributeValue("Vendor Name");
			String VendorBillNo = masterDto.getAttributeValue("Vendor Bill No");
			String billDate = masterDto.getAttributeValue("Bill Date");

			WebElement action = driver.findElement(By.xpath("//div[text()='"+billNo+"']//parent::div//parent::div/div/div/button"));

			action.click(); 
			Thread.sleep(3000);

			List<WebElement> ele = driver.findElements(By.xpath("//div[text()='"+billNo+"']//parent::div//parent::div/div/div/ul/li"));
			int ele1 = ele.size();
			System.out.println(ele1);

			try {

				for (int i = 1; i <ele1; i++) 
				{
					String act = driver.findElement(By.xpath("//div[text()='"+billNo+"']//parent::div//parent::div/div/div/ul/li["+ele1+"]/a")).getText();

					generateLogWithSS("Actions being displayed on users login : "+act);

				}
			} catch (Exception e) {
				// TODO: handle exception
			} 



			driver.findElement(By.xpath("//a[text()=' Edit']")).click();
			Thread.sleep(3000);

			//		billCheckingTransactionPage.addData().click();
			XSSFWorkbook wb = p.intializeExcelPath(currentDir, excelPath1);

			int i = 2; 

			String sheetName = "billChecking";


			String BillType1;
			String AssignTo1;
			String VendorName1;
			String VendorBillNo1;
			String BillDate1;
			String ReceivedDate1;
			String Debitadvance1;
			String Taxableamount1;
			String IGSTYesNo1;
			String IGST_GST1;
			String RoundOff1;
			String TCS1;

			String TDSApplicable1;
			String TCSApplicable1;
			String Orignalbillneeded1;

			String UploadAttachment1;
			String TDSsection1;
			String TDSConstitution1;
			String Remark1;
			String AuditRemark1;

			//ReceivedDate
			float expected_per;
			float expected_TDSAmnt;
			float actual_TDSAmount;
			float actual_TDSPer;
			float actual_NetPayment;
			float expected_NetPayment;


			if (BillType != null && !BillType.isEmpty()) {
				// Perform the action on the non-empty string
				billCheckingTransactionPage.billType().sendKeys(BillType,Keys.ENTER);
				Thread.sleep(3000);

			}
			else 
			{

			}
			Thread.sleep(3000);


			if (AssignTo != null && !AssignTo.isEmpty()) {
				// Perform the action on the non-empty string
				billCheckingTransactionPage.assignTo().sendKeys(AssignTo,Keys.ENTER);
				Thread.sleep(3000);

			}
			else 
			{

			}
			Thread.sleep(3000);

			if (VendorName != null && !VendorName.isEmpty()) {
				// Perform the action on the non-empty string
				billCheckingTransactionPage.vendorName().sendKeys(VendorName,Keys.ENTER);
				Thread.sleep(3000);
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			Thread.sleep(3000);

			if (VendorBillNo != null && !VendorBillNo.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.vendorBillNo(), VendorBillNo);
				//			billCheckingTransactionPage.vendorBillNo().sendKeys(VendorBillNo);
				Thread.sleep(3000);
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			Thread.sleep(3000);

			if (BillDate != null && !BillDate.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.billDate(), BillDate);
				//billCheckingTransactionPage.billDate().sendKeys(BillDate);
				Thread.sleep(3000);
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			Thread.sleep(3000);

			if (ReceivedDate != null && !ReceivedDate.isEmpty()) {
				// Perform the action on the non-empty string
				try {

					boolean receivedDate = billCheckingTransactionPage.receivedDate().isEnabled();

					if(receivedDate==false)
					{
						onTestFailure("Received date option is disabled.");
					}

					else if (receivedDate==true) 
					{
						onTestSuccess("Received date option is enabled.");
						utilities.insertDataInto(driver, billCheckingTransactionPage.receivedDate(), ReceivedDate);
						//billCheckingTransactionPage.receivedDate().sendKeys(ReceivedDate);
					}
				}
				catch (Exception e) {

					generateLogWithAshot("Received date option not displayed");
				}
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			Thread.sleep(3000);


			//		billCheckingTransactionPage.receivedDate().sendKeys(ReceivedDate);
			//		Thread.sleep(3000);
			if (Debitadvance != null && !Debitadvance.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.debitAdvance(), Debitadvance);
				//billCheckingTransactionPage.debitAdvance().sendKeys(Debitadvance);
				Thread.sleep(3000);
				Debitadvance1 = Debitadvance;
				Thread.sleep(3000);
			} 
			else
			{
				Debitadvance1 = billCheckingTransactionPage.debitAdvance().getAttribute("value");

			}
			Thread.sleep(3000);

			if (Taxableamount != null && !Taxableamount.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.taxableAmount(), Taxableamount);
				//billCheckingTransactionPage.taxableAmount().sendKeys(Taxableamount);
				Thread.sleep(3000);
				Taxableamount1 = Taxableamount;
				Thread.sleep(3000);
			} 
			else
			{
				Taxableamount1 = billCheckingTransactionPage.taxableAmount().getAttribute("value");

			}
			Thread.sleep(3000);



			if(IGSTYesNo.equalsIgnoreCase("yes"))
			{

				//billCheckingTransactionPage.igstAmountYesNo().click();
				Thread.sleep(3000);
				utilities.insertDataInto(driver, billCheckingTransactionPage.gstAmount(), IGST_GST);

				//billCheckingTransactionPage.gstAmount().sendKeys(IGST_GST);
				Thread.sleep(3000);
				IGST_GST1 = IGST_GST;
				Thread.sleep(3000);
			} 
			else
			{
				IGST_GST1 = billCheckingTransactionPage.gstAmount().getAttribute("value");

			}
			Thread.sleep(3000);

			//		billCheckingTransactionPage.gstAmount().sendKeys(IGST_GST);
			//		Thread.sleep(3000);

			if (RoundOff != null && !RoundOff.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.roundOff(), RoundOff);
				//billCheckingTransactionPage.roundOff().sendKeys(RoundOff);
				Thread.sleep(3000);
				RoundOff1 = RoundOff;
				Thread.sleep(3000);
			} 
			else
			{
				RoundOff1 = billCheckingTransactionPage.roundOff().getAttribute("value");

			}
			Thread.sleep(3000);

			if (TCS != null && !TCS.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
				//billCheckingTransactionPage.tcs().sendKeys(TCS);
				Thread.sleep(3000);
				TCS1 = TCS;
				Thread.sleep(3000);
			} 
			else
			{
				TCS1 = billCheckingTransactionPage.tcs().getAttribute("value");
			}
			Thread.sleep(3000);



			//		Bill Amount = Taxable Amount + GST + Round Off + TCS
			//				It is read only field.

			float Debit_Advance = Float.parseFloat(Debitadvance1);
			float Taxable_amount = Float.parseFloat(Taxableamount1);
			float Round_Off = Float.parseFloat(RoundOff1);
			float tcs = Float.parseFloat(TCS1);
			float igst_gst = Float.parseFloat(IGST_GST1);
			Thread.sleep(3000);

			float Bill_Amount = Taxable_amount+igst_gst+tcs+Round_Off;
			Thread.sleep(3000);

			String billAmt = billCheckingTransactionPage.billAmount().getAttribute("value");
			float bAmt = Float.parseFloat(billAmt);

			System.out.println("Expected Bill amount = "+Bill_Amount);
			System.out.println("Actual Bill amount = "+bAmt);

			if(Bill_Amount==bAmt)
			{
				onTestSuccess("Expected Bill amount = "+Bill_Amount+"<br />Actual Bill amount = "+bAmt);
			}

			//		if (BillDate != null && !BillDate.isEmpty()) {
			//			// Perform the action on the non-empty string
			//			utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
			//			//billCheckingTransactionPage.tcs().sendKeys(TCS);
			//			Thread.sleep(3000);
			//		} 
			//		else
			//		{
			//			// Handle the case of an empty or null string
			//
			//		}
			//		Thread.sleep(3000);
			//		
			//		if(TCSApplicable.equalsIgnoreCase("yes"))
			//		{
			//			billCheckingTransactionPage.isTCSApplicable().click();
			//			Thread.sleep(3000);
			//		}

			//		if(Orignalbillneeded.equalsIgnoreCase("yes"))
			//		{
			//			billCheckingTransactionPage.orignalBillNeedded().click();
			//			Thread.sleep(3000);
			//		}



			Thread.sleep(3000);

			if (BillDate != null && !BillDate.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
				//billCheckingTransactionPage.tcs().sendKeys(TCS);
				Thread.sleep(3000);
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			Thread.sleep(3000);


			if (TDSApplicable != null && !TDSApplicable.isEmpty())
			{	

				boolean tds = billCheckingTransactionPage.isTDSApplicable().isSelected();

				if(tds = true)
				{
					if(TDSApplicable.equalsIgnoreCase("yes"))
					{
						//					billCheckingTransactionPage.isTDSApplicable().click();
						//					Thread.sleep(3000);

						//String TDSsection = p.toReadDataFromExcel(wb, sheetName, i, 14);
						//	String TDSConstitution = p.toReadDataFromExcel(wb, sheetName, i, 15);

						Thread.sleep(4000);

						//WebElement tdsSection = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[1]/div/div/div[1]/div[1]"));


						//WebElement tdsConstitution = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[2]/span/div/div/div[1]/div[2]"));


						//			@FindBy(xpath ="/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[1]/div/div/div[1]/div[1]")
						//			private WebElement tdsSection;
						//							
						//			public WebElement tdsSection()
						//			{
						//				return tdsSection;
						//			} 
						WebElement tdsSection = driver.findElement(By.xpath("//label/b[text()='TDS section : ']/parent::label//parent::div/div/div/div/div/input"));
						Thread.sleep(2000);

						if (TDSsection != null && !TDSsection.isEmpty())
						{
							// Perform the action on the non-empty string
							//utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
							tdsSection.sendKeys(TDSsection,Keys.ENTER);
							Thread.sleep(3000);
						} 
						else
						{
							// Handle the case of an empty or null string

						}


						WebElement tdsConstitution = driver.findElement(By.xpath("//label/b[text()='TDS Constitution : ']/parent::label//parent::div/span/div/div/div/div/input"));
						Thread.sleep(3000);


						if (tdsConstitution != null && !TDSConstitution.isEmpty())
						{
							// Perform the action on the non-empty string
							//utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
							tdsConstitution.sendKeys(TDSConstitution,Keys.ENTER);
							Thread.sleep(3000);
						} 
						else
						{
							// Handle the case of an empty or null string

						}


						//generateLogWithAshot("Bill Type : "+BillType+"<br />Assign To : "+AssignTo+"<br />Vendor Name : "+VendorName+"<br />Vendor Bill No :"+VendorBillNo+"<br />Bill Date : "+BillDate+"<br />Received Date : "+ReceivedDate+"<br />Debit Advance : "+Debitadvance+"<br />Taxable Amount : "+Taxableamount+"<br />IGST Yes No : "+IGSTYesNo+"<br />Round Off : "+RoundOff+"<br />TCS : "+TCS); 		

						//			float expected_TDSAmnt;
						//			float actual_TDSAmount;

						if(TDSsection.equalsIgnoreCase("194a")&&TDSConstitution.equalsIgnoreCase("NON COMPANY DEDUCTEE"))
						{	
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(Taxableamount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}				

						}

						else if (TDSsection.equalsIgnoreCase("194Cb")&&TDSConstitution.equalsIgnoreCase("Company With Surcharge")) 
						{

							expected_per = 2;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Cb")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = 1;
							expected_per = 1;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}
						else if (TDSsection.equalsIgnoreCase("194J")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")||TDSsection.equalsIgnoreCase("194J")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")||TDSsection.equalsIgnoreCase("194I")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")||TDSsection.equalsIgnoreCase("194I")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = 10;
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value"); 
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194H")||TDSsection.equalsIgnoreCase("194IB")) 
						{
							//				per = 10;
							//				per = 10;
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{ 
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							} 

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Q")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")) 
						{

							//				per = 6;
							//				per = 10;
							expected_per = 6;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Q")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = (float) 0.10;
							expected_per = (float) 0.10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}
					}

					else {

						//expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

						expected_NetPayment = Math.round(Bill_Amount-Debit_Advance);	
						String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
						actual_NetPayment = Float.parseFloat(netP);

						if(expected_NetPayment==actual_NetPayment)
						{
							onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

						}

					}

				}	


				else if (tds=false)
				{
					if(TDSApplicable.equalsIgnoreCase("yes"))
					{

						billCheckingTransactionPage.isTDSApplicable().click();
						Thread.sleep(3000);

						//String TDSsection = p.toReadDataFromExcel(wb, sheetName, i, 14);
						//	String TDSConstitution = p.toReadDataFromExcel(wb, sheetName, i, 15);

						Thread.sleep(4000);

						//WebElement tdsSection = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[1]/div/div/div[1]/div[1]"));


						//WebElement tdsConstitution = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[2]/span/div/div/div[1]/div[2]"));


						//			@FindBy(xpath ="/html/body/div/div/div[2]/div[2]/div/div[2]/div/form/div[1]/div[2]/div[5]/div[1]/div/div/div[1]/div[1]")
						//			private WebElement tdsSection;
						//							
						//			public WebElement tdsSection()
						//			{
						//				return tdsSection;
						//			} 
						WebElement tdsSection = driver.findElement(By.xpath("//label/b[text()='TDS section : ']/parent::label//parent::div/div/div/div/div/input"));
						Thread.sleep(2000);

						if (BillDate != null && !BillDate.isEmpty()) {
							// Perform the action on the non-empty string
							//utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
							tdsSection.sendKeys(TDSsection,Keys.ENTER);
							Thread.sleep(3000);
						} 
						else
						{
							// Handle the case of an empty or null string

						}


						WebElement tdsConstitution = driver.findElement(By.xpath("//label/b[text()='TDS Constitution : ']/parent::label//parent::div/span/div/div/div/div/input"));
						Thread.sleep(3000);


						if (BillDate != null && !BillDate.isEmpty()) {
							// Perform the action on the non-empty string
							//utilities.insertDataInto(driver, billCheckingTransactionPage.tcs(), TCS);
							tdsConstitution.sendKeys(TDSConstitution,Keys.ENTER);
							Thread.sleep(3000);
						} 
						else
						{
							// Handle the case of an empty or null string

						}


						generateLogWithAshot("Bill Type : "+BillType+"<br />Assign To : "+AssignTo+"<br />Vendor Name : "+VendorName+"<br />Vendor Bill No :"+VendorBillNo+"<br />Bill Date : "+BillDate+"<br />Received Date : "+ReceivedDate+"<br />Debit Advance : "+Debitadvance+"<br />Taxable Amount : "+Taxableamount+"<br />IGST Yes No : "+IGSTYesNo+"<br />Round Off : "+RoundOff+"<br />TCS : "+TCS); 		

						//			float expected_TDSAmnt;
						//			float actual_TDSAmount;

						if(TDSsection.equalsIgnoreCase("194a")&&TDSConstitution.equalsIgnoreCase("NON COMPANY DEDUCTEE"))
						{	
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(Taxableamount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}				

						}

						else if (TDSsection.equalsIgnoreCase("194Cb")&&TDSConstitution.equalsIgnoreCase("Company With Surcharge")) 
						{

							expected_per = 2;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Cb")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = 1;
							expected_per = 1;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}
						else if (TDSsection.equalsIgnoreCase("194J")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")||TDSsection.equalsIgnoreCase("194J")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")||TDSsection.equalsIgnoreCase("194I")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")||TDSsection.equalsIgnoreCase("194I")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = 10;
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value"); 
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194H")||TDSsection.equalsIgnoreCase("194IB")) 
						{
							//				per = 10;
							//				per = 10;
							expected_per = 10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{ 
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							} 

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Q")&&TDSConstitution.equalsIgnoreCase("Company Without Surcharge")) 
						{

							//				per = 6;
							//				per = 10;
							expected_per = 6;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else if (TDSsection.equalsIgnoreCase("194Q")&&TDSConstitution.equalsIgnoreCase("Non Company Without Surcharge")) 
						{
							//per = (float) 0.10;
							expected_per = (float) 0.10;

							String tdsAmount=billCheckingTransactionPage.tdsAmount().getAttribute("value");
							actual_TDSAmount = Float.parseFloat(tdsAmount);

							String tdsPer=billCheckingTransactionPage.tdsPer().getAttribute("value");
							actual_TDSPer = Float.parseFloat(tdsPer);

							generateLogWithAshot("TDS Section : "+TDSsection+"<br />TDS Constitution : "+TDSConstitution);

							//expected_TDSAmnt = Taxable_amount*(expected_per/100);
							expected_TDSAmnt = (float) Math.ceil(Taxable_amount*(expected_per/100));

							if(actual_TDSPer==expected_per)
							{
								onTestSuccess("Expected TDS amount = "+expected_per+"<br />Actual TDS amount = "+actual_TDSPer);
							}

							if(expected_TDSAmnt==actual_TDSAmount)
							{
								onTestSuccess("Expected TDS amount = "+expected_TDSAmnt+"<br />Actual TDS amount = "+actual_TDSAmount);

							}

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}
						}

						else {

							//expected_NetPayment = Math.round(Bill_Amount-Debit_Advance-expected_TDSAmnt);	

							expected_NetPayment = Math.round(Bill_Amount-Debit_Advance);	
							String netP = billCheckingTransactionPage.netPayment().getAttribute("value");
							actual_NetPayment = Float.parseFloat(netP);

							if(expected_NetPayment==actual_NetPayment)
							{
								onTestSuccess("Expected TDS amount = "+expected_NetPayment+"<br />Actual TDS amount = "+actual_NetPayment);

							}

						}

					}	


					else
					{

					}
				}

				else 
				{

				}
			}

			else
			{

			}


			Thread.sleep(3000);


			try 
			{
				//			String Remark = p.toReadDataFromExcel(wb, sheetName, i, 18);
				//			String AuditRemark = p.toReadDataFromExcel(wb, sheetName, i, 19);

				if (Remark != null && !Remark.isEmpty())
				{
					// Perform the action on the non-empty string
					utilities.insertDataInto(driver, billCheckingTransactionPage.remark(), Remark);
					//billCheckingTransactionPage.remark().sendKeys(Remark);
					Thread.sleep(3000);
				} 
				else
				{
					// Handle the case of an empty or null string

				}

			} 
			catch (Exception e) {
				// TODO: handle exception
			}

		}
		try 
		{

			if (AuditRemark != null && !AuditRemark.isEmpty()) {
				// Perform the action on the non-empty string
				utilities.insertDataInto(driver, billCheckingTransactionPage.auditRemark(), AuditRemark);
				//billCheckingTransactionPage.auditRemark().sendKeys(AuditRemark);			
				Thread.sleep(3000);
			} 
			else
			{
				// Handle the case of an empty or null string

			}
			//	String AuditRemark = p.toReadDataFromExcel(wb, sheetName, i, 19);

		} catch (Exception e) {
			// TODO: handle exception
		}

		if (UploadAttachment != null && !UploadAttachment.isEmpty()) {
			// Perform the action on the non-empty string
			utilities.insertDataInto(driver, billCheckingTransactionPage.uploadAttachment(), UploadAttachment);
			//billCheckingTransactionPage.uploadAttachment().sendKeys(UploadAttachment);
			Thread.sleep(3000);		
			Thread.sleep(3000);
		} 
		else
		{
			// Handle the case of an empty or null string

		}


		js.executeScript("arguments[0].scrollIntoView();", commonFields.updateBtn());
		Thread.sleep(3000);

		commonFields.updateBtn().click();
		Thread.sleep(3000);

		generateLogWithAshot("Bill Updated Successfully");

		try {
			driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}


		//


		//			try {
		//				driver.findElement(By.xpath("//button[@class='Toastify__close-button Toastify__close-button--light']")).click();
		//			} catch (Exception e) {
		//				// TODO: handle exception
		//			}

		/*
		 * Bill Type
Assign To
Vendor Name
Vendor Bill No
Bill Date
Received Date
Debit advance
Taxable amount
IGST/GST Yes No 
IGST/GST
Round Off
TCS
Bill MAount
TDS Applicable
TCS Applicable
Orignal bill needed
Net Payment
Remark
Audit Remark
Upload Attachment
		 */
		Thread.sleep(15000);
		ll.logoutPage(driver);
	}



}
