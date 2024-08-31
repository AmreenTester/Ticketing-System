package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class StateMasterPage extends MasterClass {

	public StateMasterPage()
	{
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//button[text()='Add State']")
	private WebElement addState;

	public WebElement addState()
	{
		return addState;
	}

	@FindBy(xpath="//div[@id='country_id']/div/div/div/input")
	private WebElement country;

	public WebElement country()
	{
		return country;
	}


	@FindBy(xpath="//input[@id='state']")
	private WebElement state;

	public WebElement state()
	{
		return state;
	}


	@FindBy(xpath="//input[@id='remark']")
	private WebElement remark;

	public WebElement remark()
	{
		return remark;
	}




	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelBtn;

	public WebElement cancelBtn()
	{
		return cancelBtn;
	}

	
			//(//button[@type='button'])[5]
	@FindBy(xpath="(//div[contains(@class,'TableRow')])[1]/div[1]/div/button")
	private WebElement editBtn;

	public WebElement editBtn()
	{
		return editBtn;
	}

	@FindBy(xpath="(//button[@class=\"btn btn-outline-secondary\"])[1]")
	private WebElement search;

	public WebElement search()
	{
		return search;
	}

	@FindBy(xpath="//button[text()=' Search']")
	private WebElement searchBtn;

	public WebElement searchBtn()
	{
		return searchBtn;
	}

	@FindBy(xpath="(//button[text()='Update']")
	private WebElement updateBtn;

	public WebElement updateBtn()
	{
		return updateBtn;
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
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[3]/div")
	private WebElement viewState;
	
	public WebElement viewState()
	{
		return viewState;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[4]/div")
	private WebElement viewCountry;
	
	public WebElement viewCountry()
	{
		return viewCountry;
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
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[1]/div/button/i")
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




