package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Organization {
@FindBy(xpath = "//a[@href='/organization-list']")
private WebElement org;

public WebElement getOrganization()
{
	return org;
}

@FindBy(xpath = "//input[@placeholder='Search Organization']")
private WebElement orgsearch;

public WebElement getOrgSearch()
{
	return orgsearch;
}
@FindBy(xpath = "//tbody[@class='ant-table-tbody']")
private WebElement orgres;

public WebElement getOrgResult()
{
	return orgres;
}
@FindBy(xpath = "//a[@href='/add-orgn']")
private WebElement addorg;

public WebElement getAddOrganization()
{
	return addorg;		
}
@FindBy(id = "name")
private WebElement orgname;

public WebElement getgetOrgName()

{
	return orgname;
}
@FindBy(id = "Organization")
private WebElement orgdrop;

public WebElement getOrgNameDrop()
{
	return orgdrop;
}
@FindBy(id = "Primary_Contact")
public WebElement concat1;

public WebElement getContact1()
{
	return concat1;
}
@FindBy(id = "Secondary_Contact")
private WebElement contact2;

public WebElement getContct2()
{
	return contact2;
}
@FindBy(id = "Address")
private WebElement add;

public WebElement getAddress()
{
	return  add;
}
@FindBy(xpath = "//button[@ type='submit']")
private WebElement Save;

public WebElement getSavebtn()
{
	return Save;
}
@FindBy(xpath = "//span[contains(text(),'added')]")
private WebElement confirm;

public WebElement getaddConfirmation()
{
	return confirm;
}
@FindBy(xpath = "//span[@id='table-edit']")
private WebElement edit;

public WebElement getEditTable()
{
	return edit;	
}
@FindBy(xpath = "//span[text()='Update']")
private WebElement update;

public WebElement getUpdatebtn()
{
	return update;
}
@FindBy(xpath = "//span[contains(text(),'updated')]")
private WebElement confirmupdate;

public WebElement getConfirmUpdate()
{
	return confirmupdate;
}
@FindBy(id = "table-delete")
private WebElement delorg;

public WebElement getDeleteOrg()
{
	return delorg;
}
@FindBy(xpath = "//span[text()='Yes']")
private WebElement delconfirm;

public WebElement getDelconfirmation()
{
	return delconfirm;
}

@FindBy(xpath = "//span[contains(text(),'deleted')]")
private WebElement delmsg;

public WebElement getDeleteMSg()
{
	return delmsg;
}
@FindBy(id = "City")
private WebElement cty;


public  WebElement getCity()
{
	return cty;
}
@FindBy(id = "State")
private WebElement state;

public WebElement getState()
{
	return state;
}
@FindBy(id = "Zipcode")
private WebElement zip;

public WebElement getZipcode()
{
	return zip;
}

}
