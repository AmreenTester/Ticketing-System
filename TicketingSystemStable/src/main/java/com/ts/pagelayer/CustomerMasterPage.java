package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class CustomerMasterPage extends MasterClass{

	public CustomerMasterPage() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//a[text()='Add Customer']")//add
	private WebElement addCustomer;

	public WebElement addCustomer()
	{
		return addCustomer;
	}

	@FindBy (xpath = "//input[@name='name']")//add customer name
	private WebElement customerName;

	public WebElement customerName()
	{
		return customerName;
	}

	@FindBy (xpath = "//div[@id='customer_type_id']/div/div/div/input")//add customer id
	private WebElement customerId;

	public WebElement customerId()
	{
		return customerId;
	}
	@FindBy (xpath = "//input[@name='email_id']")//add customer id
	private WebElement emailId;

	public WebElement emailId()
	{
		return emailId;
	}


	@FindBy (xpath = "//input[@name='contact_no']")//add customer id
	private WebElement contactNumber;

	public WebElement contactNumber()
	{
		return contactNumber;
	}
	

	@FindBy (id="remark")
	private WebElement remark;

	public WebElement remark()
	{
		return remark;
	}
	@FindBy (xpath = "//textarea[@name='address']")//add customer id
	private WebElement address;

	public WebElement address()
	{
		return address;
	}

	@FindBy (xpath ="//input[@name='pincode']")
	private WebElement pincode;

	public WebElement pincode()
	{
		return pincode;
	}

	@FindBy (xpath ="//div[@id='country_id']/div/div/div/input")
	private WebElement countryId;

	public WebElement countryId()
	{
		return countryId;
	}
	@FindBy (xpath ="//div[@id='state_id']/div/div/div/input")
	private WebElement stateId;

	public WebElement stateId()
	{
		return stateId;
	}


	@FindBy (xpath ="//div[@id='city_id']/div/div/div/input")
	private WebElement cityId;

	public WebElement cityId()
	{
		return cityId;
	}

	@FindBy (xpath ="//button[@type='submit']")
	private WebElement submit;

	public WebElement submit()
	{
		return submit;
	}

	@FindBy (xpath ="//a[text()='Cancel']")
	private WebElement Cancel;

	public WebElement Cancel()
	{
		return Cancel;
	}

	@FindBy (xpath ="//input[@type='text']")//text bar
	private WebElement text;

	public WebElement text()
	{
		return text;
	}

	@FindBy(xpath="//input[@id='is_active_0']")
	private WebElement deactiveStatus;

	public WebElement deactiveStatus()
	{
		return deactiveStatus;
	}
	
	@FindBy(xpath="//input[@id='is_active_1']")
	private WebElement activeStatus;

	public WebElement activeStatus()
	{
		return activeStatus;
	}
	
	@FindBy (xpath ="//button[text()=' Search']")//search button
	private WebElement Search;

	public WebElement Search()
	{
		return Search;
	}

	@FindBy (xpath ="//button[text()=' Reset']")
	private WebElement Reset;

	public WebElement Reset()
	{
		return Search;
	}

	@FindBy (xpath ="//button[text()='Export']")
	private WebElement Export;

	public WebElement Export()
	{
		return Export;
	}

	@FindBy (xpath ="//button[text()='Update']")//update button
	private WebElement update;

	public WebElement update()
	{
		return update;
	}


	@FindBy (xpath ="//a[text()='Cancel']")
	private WebElement cancel;

	public WebElement cancel()
	{
		return cancel;
	}

	@FindBy (xpath ="(//div[contains(@class,'TableRow')])[1]//i")
	private WebElement editBtn;

	public WebElement editBtn()
	{
		return editBtn;
	}
	
	
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[3]/div")
	private WebElement viewName;
	
	public WebElement viewName()
	{
		return viewName;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[4]/div")
	private WebElement viewType;
	
	public WebElement viewType()
	{
		return viewType;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[5]/div/span")
	private WebElement viewStatus;
	
	public WebElement viewStatus()
	{
		return viewStatus;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[7]/div")
	private WebElement viewCreatedBy;
	
	public WebElement viewCreatedBy()
	{
		return viewCreatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[6]/div")
	private WebElement viewCreatedAt;
	
	public WebElement viewCreatedAt()
	{
		return viewCreatedAt;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[9]/div")
	private WebElement viewUpdatedBy;
	
	public WebElement viewUpdatedBy()
	{
		return viewUpdatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[8]/div")
	private WebElement viewUpdatedAt;
	
	public WebElement viewUpdatedAt()
	{
		return viewUpdatedAt;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[1]/div//i")
	private WebElement viewAction;
	
	public WebElement viewAction()
	{
		return viewAction;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[2]/div")
	private WebElement viewSrno;
	
	public WebElement viewSrno()
	{
		return viewSrno;
	}
	
	
}




