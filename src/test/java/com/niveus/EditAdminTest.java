package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class EditAdminTest extends Base {

	public LoginPage log;
	public AdminPage adpage;
	Utility ut = new Utility();

	WebDriverWait wait;

	@Test(enabled=false)
	public void editAdminValidation() {
		test = extent.createTest("13.Edit Admin", "This test case is to edit the admin");

		log = PageFactory.initElements(driver, LoginPage.class);

		adpage = PageFactory.initElements(driver, AdminPage.class);

		Reporter.log("Edit  admin  script is !!!.....!!!!!", true);

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

		wait.until(ExpectedConditions.elementToBeClickable(adpage.getadminLink()));

		adpage.getadminLink().click();

		wait.until(ExpectedConditions.visibilityOf(adpage.getEditAdmin()));

		adpage.getEditAdmin().click();

		wait.until(ExpectedConditions.visibilityOf(adpage.getaFname()));

		adpage.getaFname().sendKeys("aa");
		adpage.getaLastName().sendKeys("v");

		wait.until(ExpectedConditions.elementToBeClickable(adpage.getUpdateBtn()));

		adpage.getUpdateBtn().click();

		wait.until(ExpectedConditions.visibilityOf(adpage.getConfirmUpdate()));

		boolean result = adpage.getConfirmUpdate().getText().contains("updated");

		Assert.assertTrue(result);

		Reporter.log(adpage.getConfirmUpdate().getText(), true);

		Reporter.log("Edit admin test is pass...!!!...done...!!!");

	}
}
