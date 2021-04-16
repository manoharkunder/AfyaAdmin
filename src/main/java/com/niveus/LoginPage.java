package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "Email_Id")
	private WebElement email;
	
	public WebElement getEmailId()
	{
		return email;
	}
	
	@FindBy(id = "Password")
	private WebElement pwd;
	
	public WebElement getpassword()
	{
		return pwd;
	}
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement log;
	
	public WebElement getlogin()
	{
		return log;
	}
	@FindBy(xpath = "//span[text()='Invalid Credentials']")
	private WebElement wrong;
	
	public WebElement getWrongCredential()
	{
		return wrong;
	}
	@FindBy(xpath = "//span[text()='User is not a Super Admin or Admin']")
	private WebElement invalid;
	
	public WebElement getInvaliduser()
	{
		return invalid;
	}
	
	@FindBy(xpath = "//button[@type='submit']/span[text()='Yes']")
	private WebElement yes;
	
	public WebElement getBtnYes()
	{
		return yes;
	}
}
