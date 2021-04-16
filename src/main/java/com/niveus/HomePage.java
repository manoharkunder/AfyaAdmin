package com.niveus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//button[@id='button-logout']")
	private WebElement logout;
	
	public WebElement getlogoutBtn()
	{
		return logout;
	}
	
	@FindBy(xpath ="//div[@title='MASTER']")
	private WebElement  mast;
	
	public WebElement getmasterSection()
	{
		return mast;
	}
	
	@FindBy(xpath = "//a[@href='/speciality']/..")
	private WebElement spec;
	
	public WebElement  getmSpeciality()
	{
		return spec;
	}
	@FindBy(xpath = "//span[text()='Add Specialty']/..")
	private WebElement addspec;
	
	public WebElement getaddSpec()
	{	
		return addspec;
	}
	@FindBy(xpath = "//input[@placeholder='Specialty Name']")
	private WebElement txt;
	
	public WebElement gettextArea()
	{
		return txt;
	}
	
	@FindBy(xpath = "//span[text()='Add ']")
	private WebElement add;
	
	public WebElement getaddnutton()
	{
		return add;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Added')]")
	private WebElement specmessage;
	
	public WebElement getconformSpec()
	{
		return specmessage;
	}
	
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	
	private WebElement speclist;
	
	public WebElement getSpecList()
	{
		return speclist;
	}
	@FindBy(xpath = "//li[@title='Next Page']")
	private WebElement nxt;
	
	public WebElement getnextBtn()
	{
		return nxt;
	}
	
	@FindBy(xpath = "//span[@id='table-edit']")
	private WebElement edit;
	
	public WebElement geteditButton()
	{
		return edit;
	}
	@FindBy(xpath = "//div[@class='ant-spin-container']")
	private WebElement editone;
	
	public WebElement getEditOne()
	{
		return editone;
	}
	
	@FindBy(xpath = "//span[text()='Update ']")
	private WebElement upbtn;
	
	public WebElement getUpdatebtn()
	{
		return upbtn;
	}
	@FindBy(xpath = "//span[@id='table-delete']")
	private WebElement delid;
	
	public WebElement getDelete()
	{
		return delid;
	}
	
	@FindBy(xpath = "//span[contains(text(),'deleted')]")
	private WebElement del;
	
	public WebElement getdeleteMsg()
	{
		return del;
	}
	@FindBy(xpath = "//span[contains(text(),'Updated')]")
	private WebElement update;
	
	public WebElement getConfirnUpdate()
	{
		return update;
	}
	@FindBy(xpath = "//input[@placeholder='Search specialty']")
	
	private WebElement search;
	
	public WebElement getSearchSpecialty()
	{
		return search;
	}
	@FindBy(xpath = "//td[@class='ant-table-cell']/span")
	private WebElement list;
	
	public WebElement getSearchlist()
	{
		return list;
	}
	
}
