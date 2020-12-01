package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class InValidLoginTest extends Base
{
	public LoginPage log;

	@Test
	public void InvalidLoginValidation() 
	{
		test=extent.createTest("18.Invalid LoginTest","This test case is to check invalid login");

		log=PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("Invalid  login script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("superadmi@afya.net");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		
		WebDriverWait wait1=new WebDriverWait(driver, 15);
		
		wait1.until(ExpectedConditions.visibilityOf(log.getWrongCredential()));
		
		boolean result=log.getWrongCredential().getText().contains("Invalid");
		
		Assert.assertTrue(result);
		
		Reporter.log("Invalid  login script is sucessfully done################################",true);
	}
}
