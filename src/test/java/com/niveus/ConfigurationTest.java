package com.niveus;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ConfigurationTest extends Base{

	WebDriverWait tt;
	Organization org;
	public LoginPage log;
	public Configuration config;
	Utility ut=new Utility();

	@Test
	public void configurationValidation() throws Exception
	{
		
		test=extent.createTest("11.Configuration","This test case is used to check the configuration");

        config=PageFactory.initElements(driver, Configuration.class);
		log=PageFactory.initElements(driver, LoginPage.class);

		Reporter.log(" Orgconfiguration  script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("superadmin@afya.net");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		
		
		Reporter.log("Admin login  is  done####",true);
		
		Reporter.log("Org Search testcase is running>>>>>>>>>>>>>>>>>",true);
	
		
		org=PageFactory.initElements(driver, Organization.class);
		
		 tt=new WebDriverWait(driver, 20);
		
		 tt.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));
		
		org.getOrganization().click();
		
		Thread.sleep(3000);
		
		tt.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));
		
		org.getOrgSearch().sendKeys("TestYantra");
		
		Thread.sleep(5000);
		
		tt.until(ExpectedConditions.visibilityOf(org.getOrgResult()));
	
		boolean res=org.getOrgResult().getText().contains("Testyantra");
	
		Assert.assertTrue(res);
		
		Reporter.log("searchOrgValidation is  done###",true);
		
		org.getEditTable().click();
		
		tt.until(ExpectedConditions.visibilityOf(config.getConfiguration()));
		
		config.getConfiguration().click();
		
		Thread.sleep(5000);
		
	//	tt.until(ExpectedConditions.visibilityOf(config.getConsultComplete()));
		
		config.getConsultComplete().click();
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		Thread.sleep(5000);
		ut.moveToElement(driver, config.getSubmitBtn());
	//	config.getSubmitBtn().click();
	}
}
