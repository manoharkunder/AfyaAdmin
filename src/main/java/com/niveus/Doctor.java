package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Doctor {

	@FindBy(xpath = "//a[@href='/user-list']")
	private WebElement usr;
	
	public WebElement getUser()
	{
		return usr;
	}
	
	@FindBy(xpath = "//a[@href='/add-user']")
	private WebElement addusr;
	
	public WebElement getAddUSerLink()
	{
		return addusr;
	}
	@FindBy(id = "npi")
	private WebElement npi;
	
	public WebElement getNpi()
	{
		return npi;
	}
	@FindBy(id="First_Name")
	private WebElement name;
	
	public WebElement getFirstname()
	
	{
	return name;
	}
	@FindBy(id = "Last_Name")
	private WebElement lname;
	
	public WebElement getLastName()
	{
		return lname;
	}
	@FindBy(id = "dob")
	private WebElement usrdob;
	
	
	public WebElement getDOB()
	{
		return usrdob;
	}
	@FindBy(id = "Email_Id")
	private WebElement email;
	
	public WebElement getEmailId()
	{
	   return email;
	}
	@FindBy(id = "Password")
	private WebElement pwd;
	
	public WebElement getPassword()
	{
		return pwd;
	}
	@FindBy(id = "Mobile_Number")
	private WebElement mbno;
	
	public WebElement getMobileNO()
	{
		return mbno;
	}
	@FindBy(id = "Experience_In_Year")
	private WebElement expr;
	
	public WebElement getExperiance()
	{
		return expr;
	}
	@FindBy(id = "Hospital_Name")
	private  WebElement hname;
	
	public WebElement getHsptlname()
	{
		return hname;
	}
	@FindBy(id = "Speciality")
	private WebElement spec;
	
	
	public WebElement getSpecialty()
	{
		return spec;
	}
	@FindBy(id = "About_Doctor")
	private WebElement doc;
	
	public WebElement getAbout()
	{
		return doc;
	}
	@FindBy(xpath = "//input[contains(@id,'Organization')]")
	private WebElement org;
	
	public WebElement getOrganization()
	{
		return org;
	}
	@FindBy(xpath = "//input[contains(@id,'Roles')]")
	private WebElement role;
	
	public  WebElement getSelectRole()
	{
		return role;
	}
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement save;
	
	public WebElement getSaveBtn()
	{
		return save;
	}
	@FindBy(xpath = "//span[contains(text(),'added')]")
	private WebElement add;
	
	public WebElement getConfirmUsr()
	{
		return add;
	}
	@FindBy(xpath = "//input[@placeholder='Search Doctor']")
	private WebElement seach;

	public WebElement getOrgSearchSpec()
	{
	return seach;
	}
	@FindBy(xpath = "//tr[contains(@class,'ant-table-ro')]")
	private WebElement spec1;

	public WebElement getSpecialtySearch()
	{
		return spec1;
	}
}
