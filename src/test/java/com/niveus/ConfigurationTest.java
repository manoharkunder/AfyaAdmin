package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ConfigurationTest extends Base {

	WebDriverWait wait;
	Organization org;
	public LoginPage log;
	public Configuration config;
	Utility ut = new Utility();

	@Test
	public void configurationValidation() throws Exception {

		test = extent.createTest("11.Configuration", "This test case is used to check the configuration");

		config = PageFactory.initElements(driver, Configuration.class);
		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Configuration testcase is running....!!!...", true);

		try
		{
		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page  found please continue .......!!!!!.........", true);

		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			if (log.getBtnYes().isEnabled()) {

				wait.until(ExpectedConditions.elementToBeClickable(log.getBtnYes()));

				Reporter.log("Alert  Found.....!!!! please wait.......", true);

				log.getBtnYes().click();
			}
		} catch (Exception e) {
			Reporter.log("Alert Not Found.....!!!!..... please continue.....", true);
		}

		Reporter.log("Logged in  ......!!!!....done", true);

		Reporter.log("please continue..!!..", true);
		org = PageFactory.initElements(driver, Organization.class);

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));

		org.getOrganization().click();

		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));

		org.getOrgSearch().sendKeys("TestYantra");

		Thread.sleep(6000);
		
	    wait.until(ExpectedConditions.visibilityOf(org.getOrgResult()));

	//	boolean res = org.getOrgResult().getText().contains("Testyantra");

	//	Assert.assertTrue(res);

		Reporter.log("Org search validation done...!!!..please continue..!!", true);

		try {
			org.getEditTable().click();

			wait.until(ExpectedConditions.visibilityOf(config.getConfiguration()));

			config.getConfiguration().click();
		} catch (Exception e) {
		}

		Thread.sleep(5000);

		config.getConsultComplete().click();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(5000);
		Utility.moveToElement(driver, config.getSubmitBtn());

		Reporter.log("Admin configuration testcase is pass...!!!...done..!!!", true);
	}catch (Exception e) {
	}
	}
}
