package com.niveus;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddOrganizationTest extends Base {
	WebDriverWait tt;
	Organization org;
	public LoginPage log;

	@Test
	public void addOrganizationValiation() throws Exception {
		test = extent.createTest("8.AddOrg", "This test case is used to add the organization");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log(" Add Organization script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login script is sucessfully done#####", true);

		org = PageFactory.initElements(driver, Organization.class);

		tt = new WebDriverWait(driver, 30);

		tt.until(ExpectedConditions.elementToBeClickable(org.getOrganization()));

		org.getOrganization().click();
		org.getAddOrganization().click();
		org.getgetOrgName().sendKeys("testyantra");
		Thread.sleep(2000);
		org.getOrgNameDrop().click();
		org.getOrgNameDrop().sendKeys("AfyaGlobal", Keys.ENTER);
	 
		Reporter.log("Sucessfullt select  the organization",true);
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
		
		boolean res=org.getSavebtn().isEnabled();
		
		Assert.assertTrue(res);
		
		Reporter.log("addOrganizationValiation TestCase is Pass###############", true);

	}
}
