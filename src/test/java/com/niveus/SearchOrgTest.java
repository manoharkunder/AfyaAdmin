package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchOrgTest extends Base{
	WebDriverWait tt;
	Organization org;
	public LoginPage log;

	
	@Test
	public void searchOrgValidationTest() throws Exception
	{
		test=extent.createTest("7.OrgSearch","This test case is used to search the organiation");


		log=PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Admin login script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

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
		
		org.getOrgSearch().sendKeys("Afya");
		
		Thread.sleep(3000);
		
		tt.until(ExpectedConditions.visibilityOf(org.getOrgResult()));
	
		boolean res=org.getOrgResult().getText().contains("Afya");
		Assert.assertTrue(res);
		
		Reporter.log("searchOrgValidation is sucessfullly done################",true);
	}
}
