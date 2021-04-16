package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UserSearchTest extends Base {

	WebDriverWait wait;
	Organization org;
	public LoginPage log;
	public Doctor doc;

	@Test
	public void SearchUSerValidation() throws Exception {
		test = extent.createTest("16.User Search", "This test case is used to search the user");

		log = PageFactory.initElements(driver, LoginPage.class);

		doc = PageFactory.initElements(driver, Doctor.class);

		Reporter.log("user search testcase is running...!!!...please..!!.wait", true);

		wait = new WebDriverWait(driver, 20);

		try {
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

			wait.until(ExpectedConditions.elementToBeClickable(doc.getUser()));

			doc.getUser().click();

			wait.until(ExpectedConditions.visibilityOf(doc.getOrgSearchSpec()));

			int count = 0;
			while (count == 0) {
				try {

					doc.getOrgSearchSpec().sendKeys("Bhat");

					if (doc.getSpecialtySearch().getText().contains("Sharmila"))

					{
						count++;
					}

				} catch (Exception e) {

					doc.getOrgSearchSpec().sendKeys(Keys.BACK_SPACE);

				}
			}

			boolean res = doc.getSpecialtySearch().getText().contains("Sharmila");

			Assert.assertTrue(res);

			Reporter.log("user search Testcase is pass..!!..done..!!", true);

		} catch (Exception e) {
		}
	}
}
