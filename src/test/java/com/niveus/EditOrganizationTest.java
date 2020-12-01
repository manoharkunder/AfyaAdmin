package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EditOrganizationTest extends Base {
	WebDriverWait tt;
	Organization org;
	public LoginPage log;

	
	@Test
	
	public void editOrganizationValidation() throws Exception
	{
		test=extent.createTest("10.Edit Organization","This test case is used to edit  the organiation");


		log=PageFactory.initElements(driver, LoginPage.class);

		Reporter.log(" Edit Organization  script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("superadmin@afya.net");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		
		
		Reporter.log("Admin login script is sucessfully done################################",true);
		
		Reporter.log("Org Search testcase is running>>>>>>>>>>>>>>>>>",true);
	
		
		org=PageFactory.initElements(driver, Organization.class);
		
		 tt=new WebDriverWait(driver, 20);
		
		 tt.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));
		
		org.getOrganization().click();
		
		Thread.sleep(3000);
		
		tt.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));
		
		org.getOrgSearch().sendKeys("Testyantra");
		
		Thread.sleep(6000);
		
		tt.until(ExpectedConditions.visibilityOf(org.getOrgResult()));
	
		boolean res=org.getOrgResult().getText().contains("Testyantra");
		Assert.assertTrue(res);
		
		Reporter.log("searchOrgValidation is  done#",true);
		
		org.getEditTable().click();
		
		Thread.sleep(5000);
		org.getgetOrgName().sendKeys("test");
		Thread.sleep(2000);
		
		org.getUpdatebtn().click();
		/*
		 * tt.until(ExpectedConditions.visibilityOf(org.getConfirmUpdate())); boolean
		 * result=org.getConfirmUpdate().getText().contains("updated");
		 * 
		 * Assert.assertTrue(result);
		 */
		
		Reporter.log("editOrganizationValidation TestCase is sucesfully pass################",true);
	}

}
