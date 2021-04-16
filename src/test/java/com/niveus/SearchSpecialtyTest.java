package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchSpecialtyTest extends Base {

	public LoginPage log;

	public HomePage home;
	WebDriverWait wait;
	Utility ut = new Utility();

	@Test
	public void searchValidationTest() throws Exception {

		test = extent.createTest("6.SpecialtySearch", "This test case is to search the   Specialty");

		log = PageFactory.initElements(driver, LoginPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		Reporter.log("Search  Specialty script  is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

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

		wait.until(ExpectedConditions.elementToBeClickable(home.getmasterSection()));

		home.getmasterSection().click();

		wait.until(ExpectedConditions.elementToBeClickable(home.getmSpeciality()));

		home.getmSpeciality().click();

		home.getSearchSpecialty().sendKeys("Anesthesiology");

		Thread.sleep(6000);

		boolean res = home.getSearchlist().getText().contains("Anesthesiology");

		Assert.assertTrue(res);
		Reporter.log(home.getSearchlist().getText() + " specialty found..!!!!!..Test...!!Pass...", true);
	}
}
