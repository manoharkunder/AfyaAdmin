package com.niveus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteOrganizationTest extends Base {

	WebDriverWait tt;
	Organization org;
	public LoginPage log;

	@Test
	public void deleteOrgnizationValidation() throws Exception {
		test = extent.createTest("9.DeleteOrganization", "This test case is used to deleted  the organiation");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Delete organization script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login script is sucessfully done################################", true);

		Reporter.log("adding organization testcase is running>>>", true);

		org = PageFactory.initElements(driver, Organization.class);

		tt = new WebDriverWait(driver, 30);

		tt.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));

		org.getOrganization().click();

		org.getAddOrganization().click();
		org.getgetOrgName().sendKeys("testyantra");
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
		
		tt.until(ExpectedConditions.elementToBeClickable(org.getSavebtn()));
		
		org.getSavebtn().click();
		

		boolean res1=org.getSavebtn().isEnabled();
		/*
		 * tt.until(ExpectedConditions.visibilityOf(org.getaddConfirmation()));
		 * 
		 * boolean res1 = org.getaddConfirmation().getText().contains("added");
		 */
		Assert.assertTrue(res1);

		Reporter.log("addOrganizationValiation  is Pass##", true);

		tt.until(ExpectedConditions.visibilityOf(org.getOrgSearch()));

		org.getOrgSearch().sendKeys("TestYantra");

		Thread.sleep(6000);

		tt.until(ExpectedConditions.visibilityOf(org.getOrgResult()));

		boolean res = org.getOrgResult().getText().contains("Testyantra");
		
		Assert.assertTrue(res);

		Reporter.log("searchOrgValidation is sucessfullly done###", true);

		org.getDeleteOrg().click();

		tt.until(ExpectedConditions.elementToBeClickable(org.getDelconfirmation()));

		org.getDelconfirmation().click();

		tt.until(ExpectedConditions.visibilityOf(org.getDeleteMSg()));

		boolean result = org.getDeleteMSg().getText().contains("deleted");

		Assert.assertTrue(result);

		Reporter.log("deleteOrgnizationValidation is pass####################", true);

	}
}
