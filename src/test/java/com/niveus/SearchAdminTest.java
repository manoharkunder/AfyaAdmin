package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchAdminTest extends Base {

	public LoginPage log;
	public AdminPage adpage;
	WebDriverWait wait;

	@Test
	public void adminSearchValidation() throws Exception {
		test = extent.createTest("8.Search Admin", "This test case is to Search the admin");

		log = PageFactory.initElements(driver, LoginPage.class);

		adpage = PageFactory.initElements(driver, AdminPage.class);

		Reporter.log("Search admin  script is running...!!!!!!!!..please wait..", true);
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

		wait.until(ExpectedConditions.visibilityOf(adpage.getadminSearch()));

		adpage.getadminSearch().sendKeys("sathish");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOf(adpage.getadminResult()));

		System.out.println(adpage.getadminResult().getText());

		boolean res = adpage.getadminResult().getText().contains("Sathish");

		Assert.assertTrue(res);

		Reporter.log("Admin Search Test  pass ...!!!!!!!!........", true);

	}
}
