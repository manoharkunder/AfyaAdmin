package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
@FindBy(xpath = "//a[@href='/admin-list']")
private WebElement admin;

public WebElement getadminLink()
{
	return admin;
}

@FindBy(xpath ="//a [@href='/add-admin']")
private WebElement addadmin;

public WebElement getaddAdmin()
{
	return addadmin;
}
@FindBy(id = "first_name")
private WebElement fname;

public WebElement getaFname() {
	return fname;
}

@FindBy(id = "last_name")
private WebElement lname;

public WebElement getaLastName()
{
	return lname;
	
}
@FindBy(id = "email")
private WebElement mail;

public WebElement getmailId() {
	return mail;
}
@FindBy(id = "password")
private WebElement pwd;

public WebElement getpassword()
{
	return pwd;
}

@FindBy(id = "Organization")
private WebElement org;

public WebElement getorgdrop()
{
	return org;
}
@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
private WebElement orgsel;

public WebElement getorgSelect()
{
	return orgsel;
}

@FindBy(xpath = "//span[text()='Save']")

private WebElement getSave;

public WebElement getsaveBtn()
{
	return getSave;
}
@FindBy(xpath = "//input[@placeholder='Search Admin']")
private WebElement search;

public WebElement getadminSearch()
{
	return search;
}
@FindBy(xpath = "//thead[@class='ant-table-thead']/following-sibling::tbody//span")
private WebElement adresult;

public WebElement getadminResult()
{
	 return adresult; 
}
@FindBy(xpath = "//span[contains(text(),'added')]")
private WebElement confirm;

public WebElement getadminConfirm()
{
return confirm;	
}
@FindBy(xpath  = "//li[@id='table-action']")
private WebElement editadmin;

public WebElement getEditAdmin()
{
	return editadmin;
}

@FindBy(xpath = "//span[text()='Update']")
private WebElement ubtn;

public WebElement getUpdateBtn()
{
	return ubtn;
}
@FindBy(xpath = "//span[contains(text(),'updated')]")
private WebElement update;


public WebElement getConfirmUpdate()
{
	return update;
}
}
