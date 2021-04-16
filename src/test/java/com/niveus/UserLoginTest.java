package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UserLoginTest extends Base {
	public LoginPage log;
	WebDriverWait wait;

	@Test
	public void UserValidationTest() {
		test = extent.createTest("19.UserLoginTest", "This test case is to User login Test");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("user login test is running..!!!...please wait..!!!", true);

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page  found please continue .......!!!!!.........", true);

		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("res1@gmail.com");

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


		wait.until(ExpectedConditions.visibilityOf(log.getInvaliduser()));

		boolean res = log.getInvaliduser().getText().contains("User is not a Super Admin or Admin");

		Assert.assertTrue(res);

		Reporter.log(log.getInvaliduser().getText() + "..!!!!.. Test case is pass..!!!!..done...", true);

	}
}
