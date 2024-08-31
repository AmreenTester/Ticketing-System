package com.ts.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ts.utils.MasterClass;

public class LoginPage extends MasterClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email_id")
	private WebElement username;
	
	public WebElement username()
	{
		return username;
	}
	
	@FindBy(id = "password")
	private WebElement password;
	
	public WebElement password()
	{
		return password;
	}
	
	@FindBy(xpath = "//button[text()='SIGN IN']")
	private WebElement signinBtn;
	
	public WebElement signinBtn()
	{
		return signinBtn;
	}
	
}
