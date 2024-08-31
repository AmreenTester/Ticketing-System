package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class DepartmentMasterPage extends MasterClass {
	
	public DepartmentMasterPage() 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath ="//button[text()='Add Department']")//add
	private WebElement addDepartment;

	public WebElement addDepartment()
	{
		return addDepartment;
	}
	
	@FindBy (xpath ="//input[@id='department']")
	private WebElement departemntName;

	public WebElement departemntName()
	{
		return departemntName;
	}
	
	@FindBy (xpath ="//input[@id='remark']")
	private WebElement deptRemark;

	public WebElement deptRemark()
	{
		return deptRemark;
	}
	@FindBy (xpath ="//button[text()='Add']")
	private WebElement submit;

	public WebElement submit()
	{
		return submit;
	}
	@FindBy (xpath ="//button[text()='Cancel']")
	private WebElement cancel;

	public WebElement cancel()
	{
		return cancel;
	}
	
	@FindBy (xpath ="//input[@type='text']")//text bar
	private WebElement text;

	public WebElement text()
	{
		return text;
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
	private WebElement updatecancel;

	public WebElement updatecancel()
	{
		return cancel;
	}

	//@FindBy (xpath ="//div[@id='cell-1-146']")
	@FindBy(xpath = "(//div[contains(@class,'TableRow')])[1]/div[1]/div/button")
	private WebElement editBtn;

	public WebElement editBtn()
	{
		return editBtn;
	}
	
	
	@FindBy (xpath ="//div[contains(@class,'TableBody')]//div[3]/div")
	private WebElement viewDepartment;

	public WebElement viewDepartment()
	{
		return viewDepartment;
	}
	
	@FindBy (xpath ="//div[contains(@class,'TableBody')]//div[4]/div/span")
	private WebElement viewStatus;

	public WebElement viewStatus()
	{
		return viewStatus;
	}

}




	


