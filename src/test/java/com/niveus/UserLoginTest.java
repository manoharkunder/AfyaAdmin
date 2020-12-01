package com.niveus;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UserLoginTest extends Base{
	public LoginPage log;

	@Test
	public void UserValidationTest()
	{
		test=extent.createTest("19.UserLoginTest","This test case is to User login Test");

		log=PageFactory.initElements(driver, LoginPage.class);

		Reporter.log("User login script is running.....>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>",true);

		WebDriverWait logp=new WebDriverWait(driver, 20);
		
		logp.until(ExpectedConditions.visibilityOf(log.getlogin()));

		
		Assert.assertEquals(log.getlogin().getText(), "LOGIN");
	
		Reporter.log("Admin login page is sucessfully displayed page is sucessfully displayed", true);
		

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(log.getEmailId()));
	
		log.getEmailId().sendKeys("test1prasanna@gmail.com");
		
		log.getpassword().sendKeys("Aa123456@");
		
		log.getlogin().click();
		WebDriverWait wait2=new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.visibilityOf(log.getInvaliduser()));
		
	  boolean res=  log.getInvaliduser().getText().contains("User is not a Super Admin or Admin");
	    
	  Assert.assertTrue(res);
	  
		Reporter.log(log.getInvaliduser().getText()+" User login script is sucessfully done################################",true);
		
	}
}
