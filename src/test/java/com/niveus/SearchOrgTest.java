package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchOrgTest extends Base {
	WebDriverWait wait;
	Organization org;
	public LoginPage log;

	@Test
	public void searchOrgValidationTest() throws Exception {
		test = extent.createTest("7.OrgSearch", "This test case is used to search the organiation");

		log = PageFactory.initElements(driver, LoginPage.class);
		org = PageFactory.initElements(driver, Organization.class);

		Reporter.log("Search org Testcase running..!!!!.please wait...!!!", true);
		
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

		wait.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));

		org.getOrganization().click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));

		org.getOrgSearch().sendKeys("lacare");

		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(org.getOrgResult()));

		boolean res = org.getOrgResult().getText().contains("LACare");

		Assert.assertTrue(res);

		Reporter.log("search Org test Pass......!!!!!.......", true);
	}
}
