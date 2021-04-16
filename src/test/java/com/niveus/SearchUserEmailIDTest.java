package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchUserEmailIDTest extends Base {

	WebDriverWait wait;
	Organization org;
	public LoginPage log;
	public Doctor doc;

	@Test
	public void SearchUSerEmailIdValidation() throws Exception {

		test = extent.createTest("17.User Search", "This test case is used to search the user based on Email id");

		log = PageFactory.initElements(driver, LoginPage.class);

		doc = PageFactory.initElements(driver, Doctor.class);

		Reporter.log("Search user email testcase is running..!!!..please wait...!!", true);
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

			wait.until(ExpectedConditions.elementToBeClickable(doc.getUser()));

			doc.getUser().click();

			Thread.sleep(4000);

			wait.until(ExpectedConditions.visibilityOf(doc.getOrgSearchSpec()));

			doc.getOrgSearchSpec().sendKeys("adarsh@gmail.com");

			Thread.sleep(5000);
			boolean res = doc.getSpecialtySearch().getText().contains("adarsh@gmail.com");

			Assert.assertTrue(res);

			Reporter.log("User email Test is pass...!!!!..done....!!", true);
		} catch (Exception e) {
		}

	}
}
