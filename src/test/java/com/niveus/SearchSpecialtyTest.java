package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchSpecialtyTest extends Base {

	public LoginPage log;

	public HomePage home;
	Utility ut = new Utility();

	@Test
	public void searchValidationTest() throws Exception {

		test = extent.createTest("6.SpecialtySearch", "This test case is to search the   Specialty");

		log = PageFactory.initElements(driver, LoginPage.class);

		home = PageFactory.initElements(driver, HomePage.class);

		Reporter.log("Search  Specialty script  is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", true);

		WebDriverWait logp = new WebDriverWait(driver, 20);

		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		Assert.assertEquals(log.getlogin().getText(), "LOGIN");

		Reporter.log("Admin login page is sucessfully displayed ", true);

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));

		log.getEmailId().sendKeys("superadmin@afya.net");

		log.getpassword().sendKeys("Aa123456@");

		log.getlogin().click();

		Reporter.log("Admin login  is sucessfully done", true);

		WebDriverWait tt = new WebDriverWait(driver, 20);

		tt.until(ExpectedConditions.elementToBeClickable(home.getmasterSection()));

		home.getmasterSection().click();

		WebDriverWait pp = new WebDriverWait(driver, 20);
		pp.until(ExpectedConditions.elementToBeClickable(home.getmSpeciality()));

		home.getmSpeciality().click();

		home.getSearchSpecialty().sendKeys("Allergy and Immunology");

		/*
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 */
		
		Thread.sleep(6000);
		boolean res = home.getSearchlist().getText().contains("Allergy and Immunology");

		Assert.assertTrue(res);

		Reporter.log(home.getSearchlist() + " search result is sucessfully done...###########################",true	);

	}
}
