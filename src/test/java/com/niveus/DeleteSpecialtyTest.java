package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteSpecialtyTest extends Base{
public LoginPage log;
	
	public HomePage home;
   Utility ut=new Utility();
   
   @Test
   
public void deleteSpecValidation() throws Exception
{
	test = extent.createTest("5.DeleteSpecialty", "This test case is to check delete Specialty");

	log = PageFactory.initElements(driver, LoginPage.class);

	home = PageFactory.initElements(driver, HomePage.class);

	Reporter.log("Delete Specialty script  is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

	WebDriverWait logp = new WebDriverWait(driver, 20);

	logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

	Assert.assertEquals(log.getlogin().getText(), "LOGIN");

	Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

	WebDriverWait wait = new WebDriverWait(driver, 200);
	wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

	log.getEmailId().sendKeys("superadmin@afya.net");

	log.getpassword().sendKeys("Aa123456@");

	log.getlogin().click();

	Reporter.log("Admin login  is sucessfully done", true);

	WebDriverWait tt = new WebDriverWait(driver, 20);

	tt.until(ExpectedConditions.elementToBeClickable(home.getmasterSection()));

	home.getmasterSection().click();

	WebDriverWait pp = new WebDriverWait(driver, 20);
	pp.until(ExpectedConditions.elementToBeClickable(home.getmSpeciality()));

	home.getmSpeciality().click();

	WebDriverWait pt = new WebDriverWait(driver, 20);
	pt.until(ExpectedConditions.elementToBeClickable(home.getaddSpec()));

	home.getaddSpec().click();

	WebDriverWait tl = new WebDriverWait(driver, 20);
	tl.until(ExpectedConditions.elementToBeClickable(home.gettextArea()));
	
	String spec=ut.generateRandomWord(2);

	home.gettextArea().sendKeys("aa"+spec);

	Thread.sleep(2000);
	WebDriverWait mt = new WebDriverWait(driver, 20);
	
	mt.until(ExpectedConditions.elementToBeClickable(home.getaddnutton()));

	home.getaddnutton().click();

	
	
	boolean res = home.getaddnutton().isEnabled();
	
	Assert.assertTrue(res);

	Reporter.log("Sucessfully added the spec " + "##########",true);

	Thread.sleep(3000);
	
	
 WebDriverWait  t=new WebDriverWait(driver, 20);
 
 t.until(ExpectedConditions.elementToBeClickable(home.getDelete()));
 
  home.getDelete().click();
 
 WebDriverWait jk=new WebDriverWait(driver, 20);
 jk.until(ExpectedConditions.visibilityOf(home.getdeleteMsg()));
 
 boolean delcon=home.getdeleteMsg().getText().contains("deleted");
 
 Assert.assertTrue(delcon);
 
 Reporter.log(home.getdeleteMsg().getText(),true);
 

 
 Reporter.log("Delete specialty testcase is sucessfullly done############################",true);
	
}
}
