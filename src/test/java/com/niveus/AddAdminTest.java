package com.niveus;

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

		wait = new WebDriverWait(driver, 20);
		Reporter.log("Add admin login script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login script is sucessfully done###", true);

		WebDriverWait jj = new WebDriverWait(driver, 10);
		jj.until(ExpectedConditions.elementToBeClickable(adpage.getadminLink()));

		adpage.getadminLink().click();
		adpage.getaddAdmin().click();
		adpage.getaFname().sendKeys("sathish");
		adpage.getaLastName().sendKeys("suresh");
		adpage.getmailId().sendKeys("sathish" + ut.generateRandomWord(2) + "@gmail.com");
		adpage.getpassword().sendKeys("Aa123456@");

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Thread.sleep(5000);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", adpage.getorgdrop());

		Thread.sleep(5000);

		adpage.getorgdrop().sendKeys("b", Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(adpage.getsaveBtn()));
		/*
		 * int count=0;
		 * 
		 * while(count<=0) {
		 * 
		 * try {
		 * 
		 * 
		 * WebDriverWait kl=new WebDriverWait(driver, 20);
		 * kl.until(ExpectedConditions.elementToBeClickable(adpage.getorgdrop()));
		 * 
		 * 
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * 
		 * executor.executeScript("arguments[0].click();",adpage.getorgdrop());
		 * 
		 * 
		 * 
		 * 
		 * WebDriverWait po=new WebDriverWait(driver, 50);
		 * 
		 * po.until(ExpectedConditions.elementToBeClickable(adpage.getorgSelect()));
		 * 
		 * 
		 * 
		 * 
		 * JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		 * 
		 * executor1.executeScript("arguments[0].click();",adpage.getorgSelect());
		 * 
		 * 
		 * count++;
		 */
		adpage.getsaveBtn().click();

		/*
		 * WebDriverWait wait3=new WebDriverWait(driver, 10);
		 * 
		 * wait3.until(ExpectedConditions.visibilityOf(adpage.getadminConfirm()));
		 * 
		 * 
		 * break; } catch (Exception e) { e.printStackTrace();
		 * 
		 * } }
		 */
		/*
		 * adpage.getsaveBtn().click();
		 * 
		 * 
		 * 
		 * WebDriverWait wait3=new WebDriverWait(driver, 10);
		 * wait3.until(ExpectedConditions.visibilityOf(adpage.getadminConfirm()));
		 */
		boolean res = adpage.getsaveBtn().isEnabled();

		Assert.assertTrue(res);
		Reporter.log("Add admin testcase is sucessfully done..............##############3#############", true);

	}
}
