package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DeleteSpecialtyTest extends Base {
	public LoginPage log;

	public HomePage home;
	Utility ut = new Utility();
	WebDriverWait wait;

	@Test

	public void deleteSpecValidation() throws Exception {
		test = extent.createTest("5.DeleteSpecialty", "This test case is to check delete Specialty");

		log = PageFactory.initElements(driver, LoginPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		Reporter.log("Delete Specialty script  is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

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

			wait.until(ExpectedConditions.elementToBeClickable(home.getmasterSection()));

			home.getmasterSection().click();

			wait.until(ExpectedConditions.elementToBeClickable(home.getmSpeciality()));

			home.getmSpeciality().click();

			wait.until(ExpectedConditions.elementToBeClickable(home.getaddSpec()));

			home.getaddSpec().click();

			wait.until(ExpectedConditions.elementToBeClickable(home.gettextArea()));

			String spec = Utility.generateRandomWord(2);

			home.gettextArea().sendKeys("aa" + spec);

			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(home.getaddnutton()));

			home.getaddnutton().click();

			boolean res = home.getaddnutton().isEnabled();

			Assert.assertTrue(res);

			Reporter.log("specialty is added...!!!!...continue", true);

			Thread.sleep(3000);

			wait.until(ExpectedConditions.elementToBeClickable(home.getDelete()));

			home.getDelete().click();

			wait.until(ExpectedConditions.visibilityOf(home.getdeleteMsg()));

			boolean delcon = home.getdeleteMsg().getText().contains("deleted");

			Assert.assertTrue(delcon);

			Reporter.log(home.getdeleteMsg().getText() + " ...!!!.validation message found..!!", true);

			Reporter.log("Delete specialty testcase pass...!!...!!!.done", true);

		} catch (Exception e) {
		}
	}
}
