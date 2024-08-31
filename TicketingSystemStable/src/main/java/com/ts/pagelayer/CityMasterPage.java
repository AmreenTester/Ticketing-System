package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class CityMasterPage extends MasterClass {
	
	public CityMasterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='btn btn-dark btn-set-task w-sm-100']")
	private WebElement addCity;
	
	public WebElement addCity()
	{
		return addCity;
	}
 
	
	//div[@id='country_id']/div/div/div/input
	@FindBy(xpath="(//div[@id='country_id']//input)[1]")
	private WebElement country;
	
    public WebElement country()
    {
    	return country;
    }
    
    @FindBy(xpath="(//div[@id='state_id']//input)[1]")
	private WebElement state;
    
    public WebElement state()
    {
    	return state;
    }
    
  
    
    @FindBy(xpath="//input[@id='city']")
   	private WebElement city;
       
       public WebElement city()
       {
       	return city;
       }
    
    
    @FindBy(xpath="//input[@id='remark']")
   	private WebElement remark;
       
       public WebElement remark()
       {
       	return remark;
       }
       
       @FindBy(xpath = "//button[text()='Add']")
      	private WebElement addBtn;
     	
      	public WebElement addBtn()
      	{
      		return addBtn;
      	}
        
     	@FindBy(xpath="//button[text()='Cancel']")
     	private WebElement cancelBtn;
      	
      	public WebElement cancelBtn()
     	{
     		return cancelBtn;
      	}
 
      	
      	@FindBy(xpath="//input[@type='text']")
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
      	
      	
          @FindBy(xpath="(//button[@class='btn btn-outline-secondary'])[1]")
   	private WebElement editBtn;
   	
   	public WebElement editBtn()
   	{
   		return editBtn;
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
	private WebElement viewCity;
	
	public WebElement viewCity()
	{
		return viewCity;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[4]/div")
	private WebElement viewState;
	
	public WebElement viewState()
	{
		return viewState;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[5]/div")
	private WebElement viewCountry;
	
	public WebElement viewCountry()
	{
		return viewCountry;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[6]/div/span")
	private WebElement viewStatus;
	
	public WebElement viewStatus()
	{
		return viewStatus;
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
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[7]/div")
	private WebElement viewCreatedAt;
	
	public WebElement viewCreatedAt()
	{
		return viewCreatedAt;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[8]/div")
	private WebElement viewCreatedBy;
	
	public WebElement viewCreatedBy()
	{
		return viewCreatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[10]/div")
	private WebElement viewUpdatedBy;
	
	public WebElement viewUpdatedBy()
	{
		return viewUpdatedBy;
	}
	
	@FindBy(xpath = "//div[contains(@class,'TableBody')]/div[1]//div[9]/div")
	private WebElement viewUpdatedAt;
	
	public WebElement viewUpdatedAt()
	{
		return viewUpdatedAt;
	}
   	
}
