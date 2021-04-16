package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InValidLoginTest extends Base {
	public LoginPage log;

	WebDriverWait wait;

	@Test
	public void InvalidLoginValidation() {
		test = extent.createTest("18.Invalid LoginTest", "This test case is to check invalid login");

		log = PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Invalid login testcase is running..!!!..please wait..!!!", true);

		wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page  found please continue .......!!!!!.........", true);

		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmi@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		wait.until(ExpectedConditions.visibilityOf(log.getWrongCredential()));

		boolean result = log.getWrongCredential().getText().contains("Invalid");

		Assert.assertTrue(result);

		Reporter.log(log.getWrongCredential().getText() + " Invalid  login script is pass....!!!!...done...!!!", true);
	}
}
