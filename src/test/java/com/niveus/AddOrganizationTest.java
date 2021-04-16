package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddOrganizationTest extends Base {
	WebDriverWait wait;
	Organization org;
	public LoginPage log;

	@Test
	public void addOrganizationValiation() throws Exception {
		test = extent.createTest("8.AddOrg", "This test case is used to add the organization");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Add organization script is running....!!!....", true);

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
		org.getgetOrgName().sendKeys("testyantra");
		Thread.sleep(2000);
		org.getOrgNameDrop().click();
		org.getOrgNameDrop().sendKeys("AfyaGlobal", Keys.ENTER);
	 
		Reporter.log("Organization selected...please.!!!..continue..!!",true);
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
		
		boolean res=org.getSavebtn().isEnabled();
		
		Assert.assertTrue(res);
		
		Reporter.log("Add Org testcase ....!!!..pass..!!.done..!!", true);

	}
}
