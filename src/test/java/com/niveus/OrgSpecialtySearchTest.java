package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class OrgSpecialtySearchTest extends Base {
	WebDriverWait wait;
	Organization org;
	public LoginPage log;
	public Doctor doc;

	@Test
	public void OrgSpecSearchValidation() throws Exception {
		test = extent.createTest("15.SpecOrgSearch", "This test case is used to search the specialty based on Org");

		log = PageFactory.initElements(driver, LoginPage.class);

		doc = PageFactory.initElements(driver, Doctor.class);

		Reporter.log(" OrgSpecSearchValidation is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);
		wait = new WebDriverWait(driver, 20);

		try
		{
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

		wait.until(ExpectedConditions.elementToBeClickable(doc.getUser()));

		doc.getUser().click();

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOf(doc.getOrgSearchSpec()));

		doc.getOrgSearchSpec().sendKeys("Obstetrics");

		Thread.sleep(5000);

		boolean res = doc.getSpecialtySearch().getText().contains("Obstetrics");

		Assert.assertTrue(res);

		Reporter.log("Org Spec Search Test  Pass..!!!!......", true);
		}
		catch (Exception e) {
		}

	}
}
