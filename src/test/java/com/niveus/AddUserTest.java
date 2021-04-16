package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddUserTest extends Base {

	public LoginPage log;
	public Doctor doc;
	WebDriverWait wait;
	Utility ut = new Utility();

	@Test
	public void addUserValidation() throws Exception {

		test = extent.createTest("12.Add USer", "This test case is to add the User");

		log = PageFactory.initElements(driver, LoginPage.class);

		doc = PageFactory.initElements(driver, Doctor.class);

		Reporter.log("add user validation testcase  is running...!!!...", true);

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

		wait.until(ExpectedConditions.visibilityOf(doc.getUser()));

		doc.getUser().click();
		wait.until(ExpectedConditions.visibilityOf(doc.getAddUSerLink()));

		doc.getAddUSerLink().click();

		wait.until(ExpectedConditions.visibilityOf(doc.getNpi()));

		doc.getNpi().sendKeys("36728217" + Utility.ranndomNumber());

		doc.getFirstname().sendKeys("all");
		doc.getLastName().sendKeys("dddd");
		doc.getDOB().sendKeys("11-11-1998");
		doc.getEmailId().sendKeys("add" + Utility.generateRandomWord(2) + "@gmail.com");
		doc.getPassword().sendKeys("Aa123456@");
		doc.getMobileNO().sendKeys("9087654563");
		doc.getExperiance().sendKeys("3");
		doc.getHsptlname().sendKeys("KMC");
		doc.getSpecialty().sendKeys("Anesthesiology", Keys.ENTER);

		Thread.sleep(5000);

		doc.getAbout().sendKeys("good");
		doc.getOrganization().sendKeys("Testyantra", Keys.ENTER);

		Thread.sleep(5000);

		doc.getSelectRole().sendKeys("Submitter Provider", Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(doc.getSaveBtn()));

		doc.getSaveBtn().click();

		boolean res = doc.getSaveBtn().isEnabled();

		Assert.assertTrue(res);

		Reporter.log("Add user testcase is ..!!.pass...!!!..done...!!", true);
	}
}
