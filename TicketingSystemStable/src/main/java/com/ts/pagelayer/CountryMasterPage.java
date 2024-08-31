package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class CountryMasterPage extends MasterClass {

	public CountryMasterPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Country']")
	private WebElement addCountry;
	
	public WebElement addCountry()
	{
		return addCountry;
	}
	
	@FindBy(id="country")
	private WebElement country;
	
	public WebElement country()
	{
		return country;
	}
	
	@FindBy(id="remark")
	private WebElement remark;
	
	public WebElement remark()
	{
		return remark;
	}
	
	@FindBy(xpath = "(//div[contains(@class,'TableRow')])[1]/div[1]/div/button")
	private WebElement editBtn;
	
	public WebElement editBtn()
	{
		return editBtn;
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
	private WebElement viewCountry;
	
	public WebElement viewCountry()
	{
		return viewCountry;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[4]/div/span")
	private WebElement viewStatus;
	
	public WebElement viewStatus()
	{
		return viewStatus;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[6]/div")
	private WebElement viewCreatedBy;
	
	public WebElement viewCreatedBy()
	{
		return viewCreatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[5]/div")
	private WebElement viewCreatedAt;
	
	public WebElement viewCreatedAt()
	{
		return viewCreatedAt;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[8]/div/span")
	private WebElement viewUpdatedBy;
	
	public WebElement viewUpdatedBy()
	{
		return viewUpdatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[7]/div/span")
	private WebElement viewUpdatedAt;
	
	public WebElement viewUpdatedAt()
	{
		return viewUpdatedAt;
	}

	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[1]//button/i")
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
