package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LogoutTest extends  Base {

	public LoginPage log;
	public HomePage home;

	@Test
	public void logoutValidationTest()
	{
		test=extent.createTest("2.Logout","This test case is to check Logout ");

		log=PageFactory.initElements(driver, LoginPage.class);

		home=PageFactory.initElements(driver, HomePage.class);

		Reporter.log("Admin Logout script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("superadmin@afya.net");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		
		WebDriverWait oo=new WebDriverWait(driver, 20);
		oo.until(ExpectedConditions.elementToBeClickable(home.getlogoutBtn()));
		
		home.getlogoutBtn().click();
		
		Reporter.log("Admin logout script is sucessfully done################################",true);
		
		
	}
}
