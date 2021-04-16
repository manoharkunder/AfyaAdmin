package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteOrganizationTest extends Base {

	WebDriverWait wait;
	Organization org;
	public LoginPage log;

	@Test
	public void deleteOrgnizationValidation() throws Exception {

		test = extent.createTest("9.DeleteOrganization", "This test case is used to deleted  the organiation");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Delete organization testcase is runnig....!!..", true);

		try {
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

			org = PageFactory.initElements(driver, Organization.class);

			wait.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));

			org.getOrganization().click();

			org.getAddOrganization().click();
			org.getgetOrgName().sendKeys("Validation");
			org.getOrgNameDrop().click();

			Thread.sleep(2000);
			org.getOrgNameDrop().sendKeys("AfyaGlobal", Keys.ENTER);

			Thread.sleep(5000);

			org.getContact1().sendKeys("7890765431");
			org.getContct2().sendKeys("3509278645");
			org.getAddress().sendKeys("AfyaIndia");

			org.getCity().sendKeys("karkala");

			org.getState().sendKeys("Karnataka");

			org.getZipcode().sendKeys("12354");

			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(org.getSavebtn()));

			org.getSavebtn().click();

			boolean res1 = org.getSavebtn().isEnabled();

			Assert.assertTrue(res1);

			Reporter.log("add organization pass...!!!..", true);

			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));

			org.getOrgSearch().sendKeys("Validation");

			Thread.sleep(80000);

		//	wait.until(ExpectedConditions.visibilityOf(org.getOrgResult()));

			boolean res = org.getOrgResult().getText().contains("Validation");

			Assert.assertTrue(res);

			Reporter.log("Org search is done...!!!...", true);

			try {
				org.getDeleteOrg().click();

				wait.until(ExpectedConditions.elementToBeClickable(org.getDelconfirmation()));

				org.getDelconfirmation().click();
				
			} catch (Exception e) {
			}
			wait.until(ExpectedConditions.visibilityOf(org.getDeleteMSg()));

			boolean result = org.getDeleteMSg().getText().contains("deleted");

			Assert.assertTrue(result);

			Reporter.log("delete Orgnization Validation is pass....!!!!..done....!!", true);

		} catch (Exception e) {
		}
	}
}
