package com.ts.pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class UserMasterPage extends MasterClass{
	
	
	public UserMasterPage()
	{
	PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath = "//a[normalize-space()='Add User']")
	private WebElement addUserButton;
	
	

	public WebElement addUserButton()
	{
		return addUserButton;
	}


	@FindBy(xpath = "//input[@placeholder='Search by User Name....']")
	private WebElement searchBar;

	public WebElement searchBar()
	{
		return searchBar;
	}


	@FindBy(xpath = "//div[@id='cell-1-899']//i[@class='icofont-edit text-success']")
	private WebElement editButton;

	public WebElement editButton()
	{
		return editButton;
	}


	@FindBy(xpath = "//button[@id='noanim-tab-example1-tab-All_Tickets']")
	private WebElement userDetailsButton;

	public WebElement userDetailsButton()
	{
		return userDetailsButton;
	}


	@FindBy(xpath = "//button[@id='noanim-tab-example1-tab-User_Settings']")
	private WebElement departmentsButton;

	public WebElement departmentsButton()
	{
		return departmentsButton;
	}



	@FindBy(xpath = "//input[@id='email_id']")
	private WebElement emailAddress;

	public WebElement emailAddress()
	{
		return emailAddress;
	}


	@FindBy(xpath = "//input[@id='user_name']")
	private WebElement username;

	public WebElement username()
	{
		return username;
	}


	@FindBy(xpath = "//input[@id='contact_no']")
	private WebElement contactNumber;

	public WebElement contactNumber()
	{
		return contactNumber;
	}


	@FindBy(xpath = "//input[@id='whats_app_contact_no']")
	private WebElement whatsappNumber;

	public WebElement whatsappNumber()
	{
		return whatsappNumber;
	}



	@FindBy(xpath = "//div[@id='role_id']//input")
	private WebElement selectRole;

	public WebElement selectRole()
	{
		return selectRole;
	}


	@FindBy(xpath = "(//div[@id='designation_id']//input)[1]")
	private WebElement selectDesignation;

	public WebElement selectDesignation()
	{
		return selectDesignation;
	}


	@FindBy(xpath = "//input[@id='is_active_1']")
	private WebElement activeStatus;

	public WebElement activeStatus()
	{
		return activeStatus;
	}


	@FindBy(xpath = "//input[@id='is_active_0']")
	private WebElement deactiveStatus;

	public WebElement deactiveStatus()
	{
		return deactiveStatus;
	}



	@FindBy(xpath = "(//div[contains(@class,'css-19bb58m')])[7]")
	private WebElement ticketTypeShow;

	public WebElement ticketTypeShow()
	{
		return ticketTypeShow;
	}


	@FindBy(xpath = "//input[@id='ticket_passing_authority_0']")
	private WebElement ticketPassingAuthorityButton;

	public WebElement ticketPassingAuthorityButton()
	{
		return ticketPassingAuthorityButton;
	}


	@FindBy(xpath = "//input[@id='is_default_0']")
	private WebElement makeDefaultButton;

	public WebElement makeDefaultButton()
	{
		return makeDefaultButton;
	}


	@FindBy(xpath = "//i[@class='icofont-plus-circle']")
	private WebElement actionButton;

	public WebElement actionButton()
	{
		return actionButton;
	}

	
	//@FindBy(xpath = "(//div[text()='CUSTOMER'])[1]")
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]/div[3]/div")
	private WebElement accountForView;
	public WebElement accountForView()
	{
		return accountForView;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]/div[4]/div")
	private WebElement customerView;
	public WebElement customerView()
	{
		return customerView;
	}
	

	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]/div[5]/div")
	private WebElement nameView;
	public WebElement nameView()
	{
		return nameView;
	}
	
	@FindBy(xpath = "//div[text()='PrashantD']")
	private WebElement username1;
	public WebElement usernamefeild()
	{
		return username1;
	}


	@FindBy(xpath = "(//span[text()='Active'])[1]")
	private WebElement status;
	public WebElement statusfeild()
	{
		return status;
	}
	

	
	//span[text()='Master']
	@FindBy (xpath = "//a[text()='Add User']")
	private WebElement addUser;
	
	public WebElement addUser()
	{
		return addUser;
	}	
	
	//span[text()='Master']
	@FindBy (id="first_name")
	private WebElement firstName;
		
	public WebElement firstName()
	{
		return firstName;
	}
	
	//span[text()='Master']
	@FindBy (id="middle_name")
	private WebElement middleName;
		
	public WebElement middleName()
	{
		return middleName;
	}	
	
	//span[text()='Master']
	@FindBy (id="last_name")
	private WebElement lastName;
			
	public WebElement lastName()
	{
		return lastName;
	}	
	
	//span[text()='Master']
	@FindBy (id="email_id")
	private WebElement emailID;
				
	public WebElement emailID()
	{
		return emailID;
	}
	
	//span[text()='Master']
	@FindBy (id="user_name")
	private WebElement userName;
					
	public WebElement userName()
	{
		return userName;
	}
		
	//span[text()='Master']
	@FindBy (id="contact_no")
	private WebElement contactNo;
					
	public WebElement contactNo()
	{
		return contactNo;
	}
	
	//span[text()='Master']
	@FindBy (name="check1")
	private WebElement sameAsContactNo;
					
	public WebElement sameAsContactNo()
	{
		return sameAsContactNo;
	}
	
	@FindBy(id="account_for")
	private WebElement accountFor;
	
	public WebElement accountFor()
	{
		return accountFor;
	}
	
	
	@FindBy(xpath="//div[@id='customer_id']//input")
	private WebElement selectCustomer;
	
	public WebElement selectCustomer()
	{
		return selectCustomer;
	}
	
	//span[text()='Master']
	@FindBy (id="whats_app_contact_no")
	private WebElement whatsappContactNo;
						
	public WebElement whatsappContactNo()
	{
		return whatsappContactNo;
	}
	
	@FindBy (id="password")
	private WebElement password;
						
	public WebElement password()
	{
		return password;
	}
	
	@FindBy (xpath="//input[@placeholder='confirmed_password']")
	private WebElement confirmPassword;
						
	public WebElement confirmPassword()
	{
		return confirmPassword;
	}
	
	@FindBy (id="react-select-2-input")
	private WebElement role;
						
	public WebElement role()
	{
		return role;
	}
	
	@FindBy (id="react-select-3-input")
	private WebElement designation;
						
	public WebElement designation()
	{
		return designation;
	}
	
	@FindBy (id="react-select-4-input")
	private WebElement country;
						
	public WebElement country()
	{
		return country;
	}
	
	@FindBy (id="react-select-5-input")
	private WebElement state;
						
	public WebElement state()
	{
		return state;
	}

	@FindBy (id="react-select-6-input")
	private WebElement city;
						
	public WebElement city()
	{
		return city;
	}
	
	@FindBy (id="react-select-7-input")
	private WebElement department;
						
	public WebElement department()
	{
		return department;
	}
	
	//id="react-select-8-input"
	@FindBy (id="react-select-8-input")
	private WebElement ticketShowType;
						
	public WebElement ticketShowType()
	{
		return ticketShowType;
	}
	
	//id="ticket_passing_authority_0"
	@FindBy (id="ticket_passing_authority_0")
	private WebElement ticketPassingAuthority;
						
	public WebElement ticketPassingAuthority()
	{
		return ticketPassingAuthority;
	}
	
	//id="is_default_0"
	@FindBy (id="is_default_0")
	private WebElement makeDefault;
						
	public WebElement makeDefault()
	{
		return makeDefault;
	}
			
	//id="address"
	@FindBy (id="address")
	private WebElement address;
						
	public WebElement address()
	{
		return address;
	}	
	
	//id="pincode"		
	@FindBy (id="pincode")
	private WebElement pincode;
						
	public WebElement pincode()
	{
		return pincode;
	}
	
	//span[text()='Next']
	@FindBy (xpath ="//span[text()='Next']")
	private WebElement nextBtn;
						
	public WebElement nextBtn()
	{
		return nextBtn;
	}
	
	
	@FindBy (xpath ="//input[@placeholder='Search by User Name....']")
	private WebElement search;
						
	public WebElement search()
	{
		return search;
	}
	
	
	
	@FindBy (xpath ="//button[@class='btn btn-sm btn-outline-primary pull-left']")
	private WebElement addDepartment;
						
	public WebElement addDepartment()
	{
		return addDepartment;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[1]/div/a/i")
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
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[3]/div")
	private WebElement viewAccount;
	
	public WebElement viewAccount()
	{
		return viewAccount;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[4]/div")
	private WebElement viewCustomer;
	
	public WebElement viewCustomer()
	{
		return viewCustomer;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[5]/div")
	private WebElement viewName;
	
	public WebElement viewName()
	{
		return viewName;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[6]/div")
	private WebElement viewEmail;
	
	public WebElement viewEmail()
	{
		return viewEmail;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[7]/div")
	private WebElement viewContactNo;
	
	public WebElement viewContactNo()
	{
		return viewContactNo;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[8]/div")
	private WebElement viewUsername;
	
	public WebElement viewUsername()
	{
		return viewUsername;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[9]/div/span")
	private WebElement viewStatus;
	
	public WebElement viewStatus()
	{
		return viewStatus;
	}
	

	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[10]/div")
	private WebElement viewCreatedAt;
	
	public WebElement viewCreatedAt()
	{
		return viewCreatedAt;
	}
	

	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[11]/div")
	private WebElement viewCreatedBy;
	
	public WebElement viewCreatedBy()
	{
		return viewCreatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[12]/div")
	private WebElement viewUpdatedAt;
	
	public WebElement viewUpdatedAt()
	{
		return viewUpdatedAt;
	}
	

	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[13]/div")
	private WebElement viewUpdatedBy;
	
	public WebElement viewUpdatedBy()
	{
		return viewUpdatedBy;
	}
}
