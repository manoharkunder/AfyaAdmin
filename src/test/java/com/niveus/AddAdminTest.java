package com.niveus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddAdminTest extends Base {

	public LoginPage log;
	public AdminPage adpage;
	Utility ut = new Utility();
	WebDriverWait wait;

	@Test
	public void addAdminValidation() throws Exception {
		test = extent.createTest("7.Add Admin", "This test case is to add the admin");

		log = PageFactory.initElements(driver, LoginPage.class);

		adpage = PageFactory.initElements(driver, AdminPage.class);

		Reporter.log("Add admin testcase is running...!!!....", true);

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

		WebDriverWait jj = new WebDriverWait(driver, 10);
		jj.until(ExpectedConditions.elementToBeClickable(adpage.getadminLink()));

		adpage.getadminLink().click();
		adpage.getaddAdmin().click();
		adpage.getaFname().sendKeys("sathish");
		adpage.getaLastName().sendKeys("suresh");
		adpage.getmailId().sendKeys("sathish" + Utility.generateRandomWord(2) + "@gmail.com");
		adpage.getpassword().sendKeys("Aa123456@");

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(5000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", adpage.getorgdrop());

		Thread.sleep(5000);

		adpage.getorgdrop().sendKeys("b", Keys.ENTER);
		try {
			adpage.getadmindrop().click();
			adpage.getadmindrop().sendKeys(Keys.ENTER);
		} catch (Exception e) {
		}

		wait.until(ExpectedConditions.elementToBeClickable(adpage.getsaveBtn()));

		boolean res = adpage.getsaveBtn().isEnabled();

		Assert.assertTrue(res);

		adpage.getsaveBtn().click();

		Reporter.log("Add admin tescase is pass..!!!.done..!!", true);

	}
}
